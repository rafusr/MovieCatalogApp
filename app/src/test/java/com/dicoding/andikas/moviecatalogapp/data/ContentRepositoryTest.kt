package com.dicoding.andikas.moviecatalogapp.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.DataSource
import com.dicoding.andikas.moviecatalogapp.data.source.local.LocalDataSource
import com.dicoding.andikas.moviecatalogapp.data.source.remote.RemoteDataSource
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow
import com.dicoding.andikas.moviecatalogapp.utils.AppExecutors
import com.dicoding.andikas.moviecatalogapp.utils.FakeContent
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

    private var movies = FakeContent.generateDummyMovies()
    private val tvShows = FakeContent.generateDummyTvShows()

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
    fun getFavoritedTvShow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShow>
        `when`(localDataSource.getFavoritedTvShow()).thenReturn(dataSourceFactory)
        contentRepository.getFavoritedTvShow()

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(FakeContent.generateDummyTvShows()))
        verify(localDataSource).getFavoritedTvShow()
        assertNotNull(tvShowEntities.data)
        assertEquals(tvShows.size.toLong(), tvShowEntities.data?.size?.toLong())
    }
}