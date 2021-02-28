package com.dicoding.andikas.moviecatalogapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.andikas.moviecatalogapp.data.source.ContentRepository
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow
import com.dicoding.andikas.moviecatalogapp.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private lateinit var tvShowViewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var contentRepository: ContentRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<TvShow>>>

    @Mock
    private lateinit var pagedList: PagedList<TvShow>

    @Before
    fun setup() {
        tvShowViewModel = TvShowViewModel(contentRepository)
    }

    @Test
    fun getTvShow() {
        val dummyTvShow = Resource.success(pagedList)
        `when`(dummyTvShow.data?.size).thenReturn(20)
        val tvShow = MutableLiveData<Resource<PagedList<TvShow>>>()
        tvShow.value = dummyTvShow

        `when`(contentRepository.getTvShow()).thenReturn(tvShow)
        val movieEntity = tvShowViewModel.getTvShow().value?.data
        verify(contentRepository).getTvShow()
        assertNotNull(movieEntity)
        assertEquals(20, movieEntity?.size)

        tvShowViewModel.getTvShow().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}