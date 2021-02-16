package com.dicoding.andikas.moviecatalogapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.andikas.moviecatalogapp.data.ContentRepository
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow

class TvShowViewModel(private val contentRepository: ContentRepository) : ViewModel() {

    fun getTvShow(): LiveData<List<TvShow>> = contentRepository.getTvShow()
}