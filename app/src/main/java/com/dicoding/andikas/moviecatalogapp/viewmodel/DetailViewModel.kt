package com.dicoding.andikas.moviecatalogapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.dicoding.andikas.moviecatalogapp.data.source.ContentRepository
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow
import com.dicoding.andikas.moviecatalogapp.vo.Resource

class DetailViewModel(private val contentRepository: ContentRepository): ViewModel() {

    private var movieId = MutableLiveData<String>()
    private var tvShowId = MutableLiveData<String>()

    fun selectedMovie(movieId: String) {
        this.movieId.value = movieId
    }

    fun selectedTvShow(tvShowId: String) {
        this.tvShowId.value = tvShowId
    }

    var movies: LiveData<Resource<Movie>> = Transformations.switchMap(movieId) {mMovieId ->
        contentRepository.getMovieDetail(mMovieId)
    }

    var tvShows: LiveData<Resource<TvShow>> = Transformations.switchMap(tvShowId) {mTvShowId ->
        contentRepository.getTvShowDetail(mTvShowId)
    }

    fun setMovieFavorite() {
        val movieResource = movies.value
        if (movieResource != null) {
            val movieData = movieResource.data
            if (movieData != null) {
                val newState = !movieData.favorited
                contentRepository.setMovieFavorite(movieData, newState)
            }

        }
    }

    fun setTvShowFavorite() {
        val tvShowResource = tvShows.value
        if (tvShowResource != null) {
            val tvShowData = tvShowResource.data
            if (tvShowData != null) {
                val newState = !tvShowData.favorited
                contentRepository.setTvShowFavorite(tvShowData, newState)
            }
        }
    }

}