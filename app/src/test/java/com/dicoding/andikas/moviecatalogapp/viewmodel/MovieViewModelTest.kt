package com.dicoding.andikas.moviecatalogapp.viewmodel

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MovieViewModelTest {

    private lateinit var movieViewModel: MovieViewModel

    @Before
    fun setup() {
        movieViewModel = MovieViewModel()
    }

    @Test
    fun getMovies() {
        val movies = movieViewModel.getMovies()
        assertNotNull(movies)
        assertEquals(12, movies.size)
    }
}