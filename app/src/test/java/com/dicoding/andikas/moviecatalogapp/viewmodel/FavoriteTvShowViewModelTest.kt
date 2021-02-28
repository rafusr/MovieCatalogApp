package com.dicoding.andikas.moviecatalogapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.andikas.moviecatalogapp.data.source.ContentRepository
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteTvShowViewModelTest {

    private lateinit var favoriteTvShowViewModel: FavoriteTvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var contentRepository: ContentRepository

    @Mock
    private lateinit var observer: Observer<PagedList<TvShow>>

    @Mock
    private lateinit var pagedList: PagedList<TvShow>

    @Before
    fun setup() {
        favoriteTvShowViewModel = FavoriteTvShowViewModel(contentRepository)
    }

    @Test
    fun getFavoriteTvShow() {
        val dummyTvShows = pagedList
        `when`(dummyTvShows.size).thenReturn(20)
        val tvShows = MutableLiveData<PagedList<TvShow>>()
        tvShows.value = dummyTvShows

        `when`(contentRepository.getFavoritedTvShow()).thenReturn(tvShows)
        val tvShowEntities = favoriteTvShowViewModel.getFavoriteTvShow().value
        verify(contentRepository).getFavoritedTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(20, tvShowEntities?.size)

        favoriteTvShowViewModel.getFavoriteTvShow().observeForever(observer)
        verify(observer).onChanged(dummyTvShows)
    }

}