package com.dicoding.andikas.moviecatalogapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.andikas.moviecatalogapp.data.source.ContentRepository
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteMovieViewModelTest {

    private lateinit var favoriteMovieViewModel: FavoriteMovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var contentRepository: ContentRepository

    @Mock
    private lateinit var observer: Observer<PagedList<Movie>>

    @Mock
    private lateinit var pagedList: PagedList<Movie>

    @Before
    fun setup() {
        favoriteMovieViewModel = FavoriteMovieViewModel(contentRepository)
    }

    @Test
    fun getFavoriteMovie() {
        val dummyMovies = pagedList
        `when`(dummyMovies.size).thenReturn(20)
        val movies = MutableLiveData<PagedList<Movie>>()
        movies.value = dummyMovies

        `when`(contentRepository.getFavoritedMovie()).thenReturn(movies)
        val movieEntities = favoriteMovieViewModel.getFavoriteMovie().value
        verify(contentRepository).getFavoritedMovie()
        assertNotNull(movieEntities)
        assertEquals(20, movieEntities?.size)

        favoriteMovieViewModel.getFavoriteMovie().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }

}