package com.dicoding.andikas.moviecatalogapp.viewmodel

import com.dicoding.andikas.moviecatalogapp.utils.DataDummy
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class DetailViewModelTest {

    private lateinit var detailViewModel: DetailViewModel
    private val dummyMovies = DataDummy.generateDummyMovies()[0]
    private val dummyTvShows = DataDummy.generateDummyTVShows()[0]
    private val movieId = dummyMovies.dataId
    private val tvShowId = dummyTvShows.dataId

    @Before
    fun setUp() {
        detailViewModel = DetailViewModel()
        detailViewModel.setSelectedMovie(movieId)
        detailViewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getDetailMovies() {
        val movies = detailViewModel.getMovie()
        assertNotNull(movies)
        assertEquals(movies.imgPoster, dummyMovies.imgPoster)
        assertEquals(movies.imgBg, dummyMovies.imgBg)
        assertEquals(movies.title, dummyMovies.title)
        assertEquals(movies.genre, dummyMovies.genre)
        assertEquals(movies.overview, dummyMovies.overview)
    }

    @Test
    fun getDetailTvShows() {
        val tvShows = detailViewModel.getTvShow()
        assertNotNull(tvShows)
        assertEquals(tvShows.imgPoster, dummyTvShows.imgPoster)
        assertEquals(tvShows.imgBg, dummyTvShows.imgBg)
        assertEquals(tvShows.title, dummyTvShows.title)
        assertEquals(tvShows.genre, dummyTvShows.genre)
        assertEquals(tvShows.overview, dummyTvShows.overview)
    }
}