package com.dicoding.andikas.moviecatalogapp.network

import com.dicoding.andikas.moviecatalogapp.model.movie.ListMovie
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.dicoding.andikas.moviecatalogapp.model.tvshow.ListTvShow
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("discover/movie")
    fun getMovies(@Query("api_key") apiKey: String): Call<ListMovie>

    @GET("movie/{movieId}")
    fun getMoviesDetails(@Path("movieId") movieId: String,
                         @Query("api_key") apiKey: String) : Call<Movie>

    @GET("discover/tv")
    fun getTvShows(@Query("api_key") apiKey: String): Call<ListTvShow>

    @GET("tv/{movieId}")
    fun getTvShowsDetails(@Path("movieId") movieId: String,
                          @Query("api_key") apiKey: String) : Call<TvShow>

}