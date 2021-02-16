package com.dicoding.andikas.moviecatalogapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.andikas.moviecatalogapp.data.ContentRepository
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie

class MovieViewModel(private val contentRepository: ContentRepository) : ViewModel() {

    fun getMovie(): LiveData<List<Movie>> = contentRepository.getMovie()
}