package com.dicoding.andikas.moviecatalogapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.andikas.moviecatalogapp.data.source.ContentRepository
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow
import com.dicoding.andikas.moviecatalogapp.utils.FakeContent
import com.dicoding.andikas.moviecatalogapp.vo.Resource
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var detailViewModel: DetailViewModel
    private val dummyMovie = Resource.success(FakeContent.generateDummyDetailMovie())
    private val movieData = dummyMovie.data
    private val movieId = movieData?.id.toString()
    private val movieState = movieData?.favorited
    private val dummyTvShow = Resource.success(FakeContent.generateDummyDetailTvShow())
    private val tvShowData = dummyTvShow.data
    private val tvShowId = tvShowData?.id.toString()
    private val tvShowState = tvShowData?.favorited

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
    fun setMovieFavorite() {
        doNothing().`when`(contentRepository).setMovieFavorite(movieData!!, movieState!!)
        detailViewModel.setMovieFavorite(movieData, movieState)

        verify(contentRepository, times(1)).setMovieFavorite(movieData, movieState)
    }

    @Test
    fun getTvShowDetail() {
        val tvShowDetail = MutableLiveData<Resource<TvShow>>()
        tvShowDetail.value = dummyTvShow

        `when`(contentRepository.getTvShowDetail(tvShowId)).thenReturn(tvShowDetail)
        detailViewModel.tvShows.observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShow)
    }

    @Test
    fun setTvShowFavorite() {
        doNothing().`when`(contentRepository).setTvShowFavorite(tvShowData!!, tvShowState!!)
        detailViewModel.setTvShowFavorite(tvShowData, tvShowState)

        verify(contentRepository, times(1)).setTvShowFavorite(tvShowData, tvShowState)
    }
}