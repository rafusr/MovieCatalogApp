package com.dicoding.andikas.moviecatalogapp.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dicoding.andikas.moviecatalogapp.data.source.local.LocalDataSource
import com.dicoding.andikas.moviecatalogapp.data.source.remote.ApiResponse
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow
import com.dicoding.andikas.moviecatalogapp.data.source.remote.RemoteDataSource
import com.dicoding.andikas.moviecatalogapp.utils.AppExecutors
import com.dicoding.andikas.moviecatalogapp.vo.Resource

class ContentRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors): ContentDataSource {

    companion object {
        @Volatile
        private var instance: ContentRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource, localData: LocalDataSource, appExecutors: AppExecutors): ContentRepository =
                instance ?: synchronized(this) {
                    instance ?: ContentRepository(remoteDataSource, localData, appExecutors)
                }
    }

    override fun getMovie(): LiveData<Resource<PagedList<Movie>>> {
        return object : NetworkBoundResource<PagedList<Movie>, List<Movie>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<Movie>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<Movie>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<Movie>>> {
                return remoteDataSource.getMovies()
            }

            override fun saveCallResult(data: List<Movie>) {
                val movieList = ArrayList<Movie>()
                for (response in data) {
                    movieList.add(Movie(
                        response.id,
                        response.backdrop_path,
                        response.original_title,
                        response.overview,
                        response.poster_path,
                        response.release_date,
                        response.favorited
                    ))
                }
                localDataSource.insertMovies(movieList)
            }

        }.asLiveData()
    }

    override fun getMovieDetail(movieId: String): LiveData<Resource<Movie>> {
        return object : NetworkBoundResource<Movie, Movie>(appExecutors) {
            override fun loadFromDB(): LiveData<Movie> {
                return localDataSource.getMovieById(movieId)
            }

            override fun shouldFetch(data: Movie?): Boolean {
                return data == null
            }

            override fun createCall(): LiveData<ApiResponse<Movie>> {
                return remoteDataSource.getMoviesDetails(movieId)
            }

            override fun saveCallResult(data: Movie) {
                localDataSource.updateMovie(data)
            }

        }.asLiveData()
    }

    override fun getFavoritedMovie(): LiveData<PagedList<Movie>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoritedMovie(), config).build()
    }

    override fun setMovieFavorite(movie: Movie, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setMovieFavorite(movie, state) }
    }

    override fun getTvShow(): LiveData<Resource<PagedList<TvShow>>> {
        return object : NetworkBoundResource<PagedList<TvShow>, List<TvShow>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<TvShow>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getTvShows(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShow>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<TvShow>>> {
                return remoteDataSource.getTvShows()
            }

            override fun saveCallResult(data: List<TvShow>) {
                val tvShowList = ArrayList<TvShow>()
                for (response in data) {
                    tvShowList.add(TvShow(
                        response.id,
                        response.backdrop_path,
                        response.first_air_date,
                        response.original_name,
                        response.overview,
                        response.poster_path,
                        response.favorited
                    ))
                }
                localDataSource.insertTvShow(tvShowList)
            }

        }.asLiveData()
    }

    override fun getTvShowDetail(tvShowId: String): LiveData<Resource<TvShow>> {
        return object : NetworkBoundResource<TvShow, TvShow>(appExecutors) {
            override fun loadFromDB(): LiveData<TvShow> {
                return localDataSource.getTvShowById(tvShowId)
            }

            override fun shouldFetch(data: TvShow?): Boolean {
                return data == null
            }

            override fun createCall(): LiveData<ApiResponse<TvShow>> {
                return remoteDataSource.getTvShowsDetails(tvShowId)
            }

            override fun saveCallResult(data: TvShow) {
                localDataSource.updateTvShow(data)
            }

        }.asLiveData()
    }

    override fun getFavoritedTvShow(): LiveData<PagedList<TvShow>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoritedTvShow(), config).build()
    }

    override fun setTvShowFavorite(tvShow: TvShow, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setTvShowFavorite(tvShow, state) }
    }
}