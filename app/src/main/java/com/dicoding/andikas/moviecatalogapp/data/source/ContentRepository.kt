package com.dicoding.andikas.moviecatalogapp.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    override fun getMovie(): LiveData<Resource<List<Movie>>> {
        return object : NetworkBoundResource<List<Movie>, List<Movie>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<Movie>> {
                return localDataSource.getMovies()
            }

            override fun shouldFetch(data: List<Movie>?): Boolean {
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
                        response.genres,
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

    override fun getFavoritedMovie(): LiveData<List<Movie>> {
        return localDataSource.getFavoritedMovie()
    }

    override fun setMovieFavorite(movie: Movie, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setMovieFavorite(movie, state) }
    }

    override fun getTvShow(): LiveData<Resource<List<TvShow>>> {
        return object : NetworkBoundResource<List<TvShow>, List<TvShow>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<TvShow>> {
                return localDataSource.getTvShows()
            }

            override fun shouldFetch(data: List<TvShow>?): Boolean {
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
                        response.genres,
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

    override fun getFavoritedTvShow(): LiveData<List<TvShow>> {
        return localDataSource.getFavoritedTvShow()
    }

    override fun setTvShowFavorite(tvShow: TvShow, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setTvShowFavorite(tvShow, state) }
    }


    /*
    override fun getMovie(): LiveData<List<Movie>> {
        remoteDataSource.getMovies(object : RemoteDataSource.MovieCallback {
            override fun onResponse(movieResponse: List<Movie>) {
                listMovies.postValue(movieResponse)
            }

        })
        return listMovies
    }

    override fun getMovieDetail(movieId: String): LiveData<Movie> {
        remoteDataSource.getMoviesDetails(movieId, object : RemoteDataSource.MovieDetailCallback {
            override fun onResponse(movieDetailResponse: Movie) {
                movies.postValue(movieDetailResponse)
            }

        })
        return movies
    }

    override fun getTvShow(): LiveData<List<TvShow>> {
        remoteDataSource.getTvShows(object : RemoteDataSource.TvShowCallback {
            override fun onResponse(tvShowResponse: List<TvShow>) {
                listTvShows.postValue(tvShowResponse)
            }

        })
        return listTvShows
    }

    override fun getTvShowDetail(tvShowId: String): LiveData<TvShow> {
        remoteDataSource.getTvShowsDetails(tvShowId, object : RemoteDataSource.TvShowDetailCallback {
            override fun onResponse(tvShowDetail: TvShow) {
                tvShows.postValue(tvShowDetail)
            }

        })
        return tvShows
    }
    */
}