package com.dicoding.andikas.moviecatalogapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.andikas.moviecatalogapp.data.ContentRepository
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow

class DetailViewModel(private val contentRepository: ContentRepository): ViewModel() {

    fun getMovieDetail(movieId: String): LiveData<Movie> = contentRepository.getMovieDetail(movieId)

    fun getTvShowDetail(tvShowId: String): LiveData<TvShow> = contentRepository.getTvShowDetail(tvShowId)

}