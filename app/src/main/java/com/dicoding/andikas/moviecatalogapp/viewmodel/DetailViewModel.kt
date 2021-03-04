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

    fun setMovieFavorite(movie: Movie, newState: Boolean) {
        contentRepository.setMovieFavorite(movie, newState)
    }

    fun setTvShowFavorite(tvShow: TvShow, newState: Boolean) {
        contentRepository.setTvShowFavorite(tvShow, newState)
    }

}