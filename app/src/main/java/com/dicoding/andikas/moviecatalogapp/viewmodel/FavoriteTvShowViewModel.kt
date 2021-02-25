package com.dicoding.andikas.moviecatalogapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.andikas.moviecatalogapp.data.source.ContentRepository
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow

class FavoriteTvShowViewModel(private val contentRepository: ContentRepository) : ViewModel() {

    fun getFavoriteTvShow(): LiveData<PagedList<TvShow>> = contentRepository.getFavoritedTvShow()

    fun setFavorite(tvShow: TvShow) {
        val newState = !tvShow.favorited
        contentRepository.setTvShowFavorite(tvShow, newState)
    }

}