package com.dicoding.andikas.moviecatalogapp.viewmodel

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TvShowViewModelTest {

    private lateinit var tvShowViewModel: TvShowViewModel

    @Before
    fun setup() {
        tvShowViewModel = TvShowViewModel()
    }

    @Test
    fun getTvShows() {
        val tvShows = tvShowViewModel.getTvShows()
        assertNotNull(tvShows)
        assertEquals(12, tvShows.size)
    }
}