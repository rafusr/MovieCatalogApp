package com.dicoding.andikas.moviecatalogapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.andikas.moviecatalogapp.data.source.ContentRepository
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie

class FavoriteMovieViewModel(private val contentRepository: ContentRepository) : ViewModel() {

    fun getFavoriteMovie(): LiveData<List<Movie>> = contentRepository.getFavoritedMovie()



}