package com.dicoding.andikas.moviecatalogapp.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow

@Dao
interface ContentDao {

    //Movie
    @Query("SELECT * FROM movieentities")
    fun getMovie(): DataSource.Factory<Int, Movie>

    @Query("SELECT * FROM movieentities where favorited = 1")
    fun getFavoritedMovie(): DataSource.Factory<Int, Movie>

    @Transaction
    @Query("SELECT * FROM movieentities WHERE movieId = :movieId")
    fun getMovieById(movieId: String): LiveData<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<Movie>)

    @Update
    fun updateMovie(movie: Movie)

    //TvShow
    @Query("SELECT * FROM tvshowentities")
    fun getTvShow(): DataSource.Factory<Int, TvShow>

    @Query("SELECT * FROM tvshowentities where favorited = 1")
    fun getFavoritedTvShow(): DataSource.Factory<Int, TvShow>

    @Transaction
    @Query("SELECT * FROM tvshowentities WHERE tvShowId = :tvShowId")
    fun getTvShowById(tvShowId: String): LiveData<TvShow>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShows(tvShows: List<TvShow>)

    @Update
    fun updateTvShow(tvShow: TvShow)
}