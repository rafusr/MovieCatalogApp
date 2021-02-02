package com.dicoding.andikas.moviecatalogapp.viewmodel

import androidx.lifecycle.ViewModel
import com.dicoding.andikas.moviecatalogapp.utils.DataDummy
import com.dicoding.andikas.moviecatalogapp.model.DataEntity

class DetailViewModel : ViewModel() {

    private lateinit var movieId: String
    private lateinit var tvShowId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun setSelectedTvShow(tvShowId: String) {
        this.tvShowId = tvShowId
    }

    fun getMovie(): DataEntity {
        lateinit var dataEntity: DataEntity
        val movies = getMovieModules()
        for (item in movies) {
            if (item.dataId == movieId) {
                dataEntity = item
                break
            }
        }
        return dataEntity
    }

    fun getTvShow(): DataEntity {
        lateinit var dataEntity: DataEntity
        val tvShows = getTvShowModules()
        for (item in tvShows) {
            if (item.dataId == tvShowId) {
                dataEntity = item
                break
            }
        }
        return dataEntity
    }

    private fun getMovieModules() = DataDummy.generateDummyMovies()

    private fun getTvShowModules() = DataDummy.generateDummyTVShows()

}