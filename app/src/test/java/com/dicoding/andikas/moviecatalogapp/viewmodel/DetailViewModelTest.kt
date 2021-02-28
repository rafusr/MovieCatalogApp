package com.dicoding.andikas.moviecatalogapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.andikas.moviecatalogapp.data.source.ContentRepository
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow
import com.dicoding.andikas.moviecatalogapp.utils.FakeContent
import com.dicoding.andikas.moviecatalogapp.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var detailViewModel: DetailViewModel
    private val dummyMovie = Resource.success(FakeContent.generateDummyDetailMovie())
    private val movieId = dummyMovie.data?.id.toString()
    private val dummyTvShow = Resource.success(FakeContent.generateDummyDetailTvShow())
    private val tvShowId = dummyTvShow.data?.id.toString()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var contentRepository: ContentRepository

    @Mock
    private lateinit var movieObserver: Observer<Resource<Movie>>

    @Mock
    private lateinit var tvShowObserver: Observer<Resource<TvShow>>


    @Before
    fun setup() {
        detailViewModel = DetailViewModel(contentRepository)
        detailViewModel.selectedMovie(movieId)
        detailViewModel.selectedTvShow(tvShowId)
    }

    @Test
    fun getMovieDetail() {
        val movieDetail = MutableLiveData<Resource<Movie>>()
        movieDetail.value = dummyMovie

        `when`(contentRepository.getMovieDetail(movieId)).thenReturn(movieDetail)
        detailViewModel.movies.observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)

    }

    @Test
    fun getTvShowDetail() {
        val dummyDetailTvShow = Resource.success(FakeContent.generateDummyDetailTvShow())
        val tvShowDetail = MutableLiveData<Resource<TvShow>>()
        tvShowDetail.value = dummyDetailTvShow
        val id = tvShowDetail.value!!.data?.id.toString()

        `when`(contentRepository.getTvShowDetail(id)).thenReturn(tvShowDetail)
        contentRepository.getTvShowDetail(id).observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyDetailTvShow)
    }
}