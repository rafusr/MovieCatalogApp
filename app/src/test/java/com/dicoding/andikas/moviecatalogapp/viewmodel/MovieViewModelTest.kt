package com.dicoding.andikas.moviecatalogapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.andikas.moviecatalogapp.FakeContent
import com.dicoding.andikas.moviecatalogapp.data.MovieRepository
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var movieViewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<List<Movie>>

    @Before
    fun setup() {
        movieViewModel = MovieViewModel(movieRepository)
    }

    @Test
    fun getMovie() {
        val dummyMovie = FakeContent.generateDummyMovies()
        val movie = MutableLiveData<List<Movie>>()
        movie.value = dummyMovie

        Mockito.`when`(movieRepository.getMovie()).thenReturn(movie)
        val movieEntity = movieViewModel.getMovie().value
        verify(movieRepository).getMovie()
        assertNotNull(movieEntity)
        assertEquals(20, movieEntity?.size)

        movieViewModel.getMovie().observeForever(observer)
        verify(observer).onChanged(dummyMovie)

    }
}