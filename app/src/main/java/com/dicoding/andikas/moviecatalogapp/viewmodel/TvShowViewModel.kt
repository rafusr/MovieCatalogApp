package com.dicoding.andikas.moviecatalogapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.andikas.moviecatalogapp.data.MovieRepository
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow

class TvShowViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getTvShow(): LiveData<List<TvShow>> = movieRepository.getTvShow()

}