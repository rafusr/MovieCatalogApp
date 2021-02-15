package com.dicoding.andikas.moviecatalogapp.data

import androidx.lifecycle.LiveData
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow

interface MovieDataSource {

    fun getMovie(): LiveData<List<Movie>>
    fun getMovieDetail(movieId: String): LiveData<Movie>
    fun getTvShow(): LiveData<List<TvShow>>
    fun getTvShowDetail(tvShowId: String): LiveData<TvShow>

}