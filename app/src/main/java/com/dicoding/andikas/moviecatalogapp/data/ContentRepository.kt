package com.dicoding.andikas.moviecatalogapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow
import com.dicoding.andikas.moviecatalogapp.remote.RemoteDataSource

class ContentRepository private constructor(private val remoteDataSource: RemoteDataSource): ContentDataSource {

    private val listMovies = MutableLiveData<List<Movie>>()
    private val movies = MutableLiveData<Movie>()
    private val listTvShows = MutableLiveData<List<TvShow>>()
    private val tvShows = MutableLiveData<TvShow>()

    companion object {
        @Volatile
        private var instance: ContentRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): ContentRepository =
                instance ?: synchronized(this) {
                    instance ?: ContentRepository(remoteDataSource)
                }
    }

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

}