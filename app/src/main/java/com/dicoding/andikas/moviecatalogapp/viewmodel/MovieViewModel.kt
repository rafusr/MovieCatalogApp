package com.dicoding.andikas.moviecatalogapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.andikas.moviecatalogapp.data.MovieRepository
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getMovie(): LiveData<List<Movie>> = movieRepository.getMovie()
}