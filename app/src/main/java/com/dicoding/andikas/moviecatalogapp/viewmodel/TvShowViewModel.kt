package com.dicoding.andikas.moviecatalogapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.andikas.moviecatalogapp.data.source.ContentRepository
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow
import com.dicoding.andikas.moviecatalogapp.vo.Resource

class TvShowViewModel(private val contentRepository: ContentRepository) : ViewModel() {

    fun getTvShow(): LiveData<Resource<PagedList<TvShow>>> = contentRepository.getTvShow()
}