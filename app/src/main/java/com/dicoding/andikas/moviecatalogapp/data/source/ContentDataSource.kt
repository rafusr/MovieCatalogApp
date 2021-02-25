package com.dicoding.andikas.moviecatalogapp.data.source

import androidx.lifecycle.LiveData
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow
import com.dicoding.andikas.moviecatalogapp.vo.Resource

interface ContentDataSource {

    fun getMovie(): LiveData<Resource<List<Movie>>>
    fun getMovieDetail(movieId: String): LiveData<Resource<Movie>>
    fun getFavoritedMovie(): LiveData<List<Movie>>
    fun setMovieFavorite(movie: Movie, state: Boolean)

    fun getTvShow(): LiveData<Resource<List<TvShow>>>
    fun getTvShowDetail(tvShowId: String): LiveData<Resource<TvShow>>
    fun getFavoritedTvShow(): LiveData<List<TvShow>>
    fun setTvShowFavorite(tvShow: TvShow, state: Boolean)
}