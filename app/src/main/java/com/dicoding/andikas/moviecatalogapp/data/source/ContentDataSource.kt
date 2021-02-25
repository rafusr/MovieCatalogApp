package com.dicoding.andikas.moviecatalogapp.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow
import com.dicoding.andikas.moviecatalogapp.vo.Resource

interface ContentDataSource {

    fun getMovie(): LiveData<Resource<PagedList<Movie>>>
    fun getMovieDetail(movieId: String): LiveData<Resource<Movie>>
    fun getFavoritedMovie(): LiveData<PagedList<Movie>>
    fun setMovieFavorite(movie: Movie, state: Boolean)

    fun getTvShow(): LiveData<Resource<PagedList<TvShow>>>
    fun getTvShowDetail(tvShowId: String): LiveData<Resource<TvShow>>
    fun getFavoritedTvShow(): LiveData<PagedList<TvShow>>
    fun setTvShowFavorite(tvShow: TvShow, state: Boolean)
}