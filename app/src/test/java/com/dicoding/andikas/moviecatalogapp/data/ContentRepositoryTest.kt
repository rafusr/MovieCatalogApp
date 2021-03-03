package com.dicoding.andikas.moviecatalogapp.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.dicoding.andikas.moviecatalogapp.data.source.local.LocalDataSource
import com.dicoding.andikas.moviecatalogapp.data.source.remote.RemoteDataSource
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow
import com.dicoding.andikas.moviecatalogapp.utils.AppExecutors
import com.dicoding.andikas.moviecatalogapp.utils.FakeContent
import com.dicoding.andikas.moviecatalogapp.utils.LiveDataTestUtil
import com.dicoding.andikas.moviecatalogapp.utils.PagedListUtil
import com.dicoding.andikas.moviecatalogapp.vo.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class ContentRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remoteRepository = mock(RemoteDataSource::class.java)
    private val localDataSource = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val contentRepository = FakeContentRepository(remoteRepository, localDataSource, appExecutors)

    private val movies = FakeContent.generateDummyMovies()
    private val tvShows = FakeContent.generateDummyTvShows()

    private val movieDetail = FakeContent.generateDummyDetailMovie()
    private val movieId = movieDetail.id.toString()
    private val movieState = movieDetail.favorited
    private val tvShowDetail = FakeContent.generateDummyDetailTvShow()
    private val tvShowId = tvShowDetail.id.toString()
    private val tvShowState = tvShowDetail.favorited

    @Test
    fun getMovie() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, Movie>
        `when`(localDataSource.getMovies()).thenReturn(dataSourceFactory)
        contentRepository.getMovie()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(FakeContent.generateDummyMovies()))
        verify(localDataSource).getMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movies.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getMovieDetail() {
        val dummyMovieDetail = MutableLiveData<Movie>()
        dummyMovieDetail.value = FakeContent.generateDummyDetailMovie()
        `when`(localDataSource.getMovieById(movieId)).thenReturn(dummyMovieDetail)

        val movieDetailEntities = LiveDataTestUtil.getValue(contentRepository.getMovieDetail(movieId))
        verify(localDataSource).getMovieById(movieId)
        assertNotNull(movieDetailEntities)
        assertEquals(movieDetail.id, movieDetailEntities.data?.id)
        assertEquals(movieDetail.backdrop_path, movieDetailEntities.data?.backdrop_path)
        assertEquals(movieDetail.original_title, movieDetailEntities.data?.original_title)
        assertEquals(movieDetail.overview, movieDetailEntities.data?.overview)
        assertEquals(movieDetail.poster_path, movieDetailEntities.data?.poster_path)
        assertEquals(movieDetail.release_date, movieDetailEntities.data?.release_date)
        assertEquals(movieDetail.favorited, movieDetailEntities.data?.favorited)
    }

    @Test
    fun getFavoritedMovie() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, Movie>
        `when`(localDataSource.getFavoritedMovie()).thenReturn(dataSourceFactory)
        contentRepository.getFavoritedMovie()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(FakeContent.generateDummyMovies()))
        verify(localDataSource).getFavoritedMovie()
        assertNotNull(movieEntities.data)
        assertEquals(movies.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun setMovieFavorite() {
        doNothing().`when`(localDataSource).setMovieFavorite(movieDetail, movieState)
        contentRepository.setMovieFavorite(movieDetail, movieState)

        verify(localDataSource).setMovieFavorite(movieDetail, movieState)
    }

    @Test
    fun getTvShow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShow>
        `when`(localDataSource.getTvShows()).thenReturn(dataSourceFactory)
        contentRepository.getTvShow()

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(FakeContent.generateDummyTvShows()))
        verify(localDataSource).getTvShows()
        assertNotNull(tvShowEntities.data)
        assertEquals(tvShows.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getTvShowDetail() {
        val dummyTvShowDetail = MutableLiveData<TvShow>()
        dummyTvShowDetail.value = FakeContent.generateDummyDetailTvShow()
        `when`(localDataSource.getTvShowById(tvShowId)).thenReturn(dummyTvShowDetail)

        val tvShowDetailEntities = LiveDataTestUtil.getValue(contentRepository.getTvShowDetail(tvShowId))
        verify(localDataSource).getTvShowById(tvShowId)
        assertNotNull(tvShowDetailEntities)
        assertEquals(tvShowDetail.id, tvShowDetailEntities.data?.id)
        assertEquals(tvShowDetail.backdrop_path, tvShowDetailEntities.data?.backdrop_path)
        assertEquals(tvShowDetail.first_air_date, tvShowDetailEntities.data?.first_air_date)
        assertEquals(tvShowDetail.original_name, tvShowDetailEntities.data?.original_name)
        assertEquals(tvShowDetail.overview, tvShowDetailEntities.data?.overview)
        assertEquals(tvShowDetail.poster_path,tvShowDetailEntities.data?.poster_path)
        assertEquals(tvShowDetail.favorited,tvShowDetailEntities.data?.favorited)
    }

    @Test
    fun getFavoritedTvShow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShow>
        `when`(localDataSource.getFavoritedTvShow()).thenReturn(dataSourceFactory)
        contentRepository.getFavoritedTvShow()

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(FakeContent.generateDummyTvShows()))
        verify(localDataSource).getFavoritedTvShow()
        assertNotNull(tvShowEntities.data)
        assertEquals(tvShows.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun setTvShowFavorite() {
        doNothing().`when`(localDataSource).setTvShowFavorite(tvShowDetail, tvShowState)
        contentRepository.setTvShowFavorite(tvShowDetail, tvShowState)

        verify(localDataSource, times(1)).setTvShowFavorite(tvShowDetail, tvShowState)

    }

}