package com.dicoding.andikas.moviecatalogapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.andikas.moviecatalogapp.data.source.ContentRepository
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.dicoding.andikas.moviecatalogapp.vo.Resource

class MovieViewModel(private val contentRepository: ContentRepository) : ViewModel() {

    fun getMovie(): LiveData<Resource<PagedList<Movie>>> = contentRepository.getMovie()
}