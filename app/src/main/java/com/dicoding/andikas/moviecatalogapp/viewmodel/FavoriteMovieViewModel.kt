package com.dicoding.andikas.moviecatalogapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.andikas.moviecatalogapp.data.source.ContentRepository
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie

class FavoriteMovieViewModel(private val contentRepository: ContentRepository) : ViewModel() {

    fun getFavoriteMovie(): LiveData<PagedList<Movie>> = contentRepository.getFavoritedMovie()

    fun setFavorite(movie: Movie) {
        val newState = !movie.favorited
        contentRepository.setMovieFavorite(movie, newState)
    }

}