package com.dicoding.andikas.moviecatalogapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.andikas.moviecatalogapp.data.MovieRepository
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow

class DetailViewModel(private val movieRepository: MovieRepository): ViewModel() {

    fun getMovieDetail(movieId: String): LiveData<Movie> = movieRepository.getMovieDetail(movieId)

    fun getTvShowDetail(tvShowId: String): LiveData<TvShow> = movieRepository.getTvShowDetail(tvShowId)

}