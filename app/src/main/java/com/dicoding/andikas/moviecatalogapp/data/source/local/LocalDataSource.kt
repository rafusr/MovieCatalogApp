package com.dicoding.andikas.moviecatalogapp.data.source.local

import androidx.lifecycle.LiveData
import com.dicoding.andikas.moviecatalogapp.data.source.local.room.ContentDao
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow

class LocalDataSource private constructor(private val mContentDao: ContentDao){

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(contentDao: ContentDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(contentDao)
    }

    //Movie
    fun getMovies(): LiveData<List<Movie>> = mContentDao.getMovie()

    fun getFavoritedMovie(): LiveData<List<Movie>> = mContentDao.getFavoritedMovie()

    fun getMovieById(movieId: String): LiveData<Movie> = mContentDao.getMovieById(movieId)

    fun insertMovies(movies: List<Movie>) = mContentDao.insertMovies(movies)

    fun setMovieFavorite(movie: Movie, newState: Boolean) {
        movie.favorited = newState
        mContentDao.updateMovie(movie)
    }
    fun updateMovie(movie: Movie) {
        mContentDao.updateMovie(movie)
    }
    //

    //TvShow
    fun getTvShows(): LiveData<List<TvShow>> = mContentDao.getTvShow()

    fun getFavoritedTvShow(): LiveData<List<TvShow>> = mContentDao.getFavoritedTvShow()

    fun getTvShowById(tvShowId: String): LiveData<TvShow> = mContentDao.getTvShowById(tvShowId)

    fun insertTvShow(tvShows: List<TvShow>) = mContentDao.insertTvShows(tvShows)

    fun setTvShowFavorite(tvShow: TvShow, newState: Boolean) {
        tvShow.favorited = newState
        mContentDao.updateTvShow(tvShow)
    }

    fun updateTvShow(tvShow: TvShow) {
        mContentDao.updateTvShow(tvShow)
    }
    //

}