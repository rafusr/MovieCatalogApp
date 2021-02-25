package com.dicoding.andikas.moviecatalogapp.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dicoding.andikas.moviecatalogapp.LiveDataTestUtil
import com.dicoding.andikas.moviecatalogapp.FakeContent
import com.dicoding.andikas.moviecatalogapp.data.source.remote.RemoteDataSource
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.eq
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class ContentRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remoteRepository = Mockito.mock(RemoteDataSource::class.java)
    private val movieRepository = FakeContentRepository(remoteRepository)

    private var movies = FakeContent.generateDummyMovies()
    private val movieId = movies[0].id.toString()

    private val tvShows = FakeContent.generateDummyTvShows()
    private val tvShowId = tvShows[0].id.toString()

    private val movieDetail = FakeContent.generateDummyDetailMovie()
    private val tvShowDetail = FakeContent.generateDummyDetailTvShow()

    @Test
    fun getMovie() {
        Mockito.doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.MovieCallback)
                    .onResponse(movies)
            null
        }.`when`(remoteRepository).getMovies(any())

        val movieEntities = LiveDataTestUtil.getValue(movieRepository.getMovie())
        Mockito.verify(remoteRepository).getMovies(any())

        assertNotNull(movieEntities)
        assertEquals(movies.size, movieEntities.size)
    }

    @Test
    fun getMovieDetail() {
        Mockito.doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.MovieDetailCallback)
                    .onResponse(movieDetail)
            null
        }.`when`(remoteRepository).getMoviesDetails(eq(movieId), any())

        val movieDetailEntities = LiveDataTestUtil.getValue(movieRepository.getMovieDetail(movieId))
        Mockito.verify(remoteRepository).getMoviesDetails(eq(movieId), any())

        assertNotNull(movieDetailEntities)
        assertEquals(movieDetail.id, movieDetailEntities.id)
        assertEquals(movieDetail.backdrop_path, movieDetailEntities.backdrop_path)
        assertEquals(movieDetail.genres, movieDetailEntities.genres)
        assertEquals(movieDetail.original_title, movieDetailEntities.original_title)
        assertEquals(movieDetail.overview, movieDetailEntities.overview)
        assertEquals(movieDetail.poster_path, movieDetailEntities.poster_path)
        assertEquals(movieDetail.release_date, movieDetailEntities.release_date)
    }

    @Test
    fun getTvShow() {
        Mockito.doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.TvShowCallback)
                    .onResponse(tvShows)
            null
        }.`when`(remoteRepository).getTvShows(any())

        val tvShowEntities = LiveDataTestUtil.getValue(movieRepository.getTvShow())
        Mockito.verify(remoteRepository).getTvShows(any())

        assertNotNull(tvShowEntities)
        assertEquals(tvShows.size, tvShowEntities.size)
    }

    @Test
    fun getTvShowDetail() {
        Mockito.doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.TvShowDetailCallback)
                    .onResponse(tvShowDetail)
            null
        }.`when`(remoteRepository).getTvShowsDetails(eq(tvShowId), any())

        val tvShowDetailEntities = LiveDataTestUtil.getValue(movieRepository.getTvShowDetail(tvShowId))
        Mockito.verify(remoteRepository).getTvShowsDetails(eq(tvShowId), any())

        assertNotNull(tvShowDetailEntities)
        assertEquals(tvShowDetail.id, tvShowDetailEntities.id)
        assertEquals(tvShowDetail.backdrop_path, tvShowDetailEntities.backdrop_path)
        assertEquals(tvShowDetail.first_air_date, tvShowDetailEntities.first_air_date)
        assertEquals(tvShowDetail.genres, tvShowDetailEntities.genres)
        assertEquals(tvShowDetail.original_name, tvShowDetailEntities.original_name)
        assertEquals(tvShowDetail.overview, tvShowDetailEntities.overview)
        assertEquals(tvShowDetail.poster_path, tvShowDetailEntities.poster_path)
    }
}