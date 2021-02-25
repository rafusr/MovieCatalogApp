package com.dicoding.andikas.moviecatalogapp.view

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.dicoding.andikas.moviecatalogapp.R
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow
import com.dicoding.andikas.moviecatalogapp.utils.EspressoIdlingResource
import com.dicoding.andikas.moviecatalogapp.view.home.MainActivity
import org.junit.After
import org.junit.Before
import org.junit.Test

class MainActivityTest {

    private val movies = ArrayList<Movie>()
    private val tvShows = ArrayList<TvShow>()

    @Before
    fun setup() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movie))
                .check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(movies.size))
    }

    @Test
    fun loadDetailMovies() {
        onView(withId(R.id.rv_movie)).perform(
                RecyclerViewActions
                        .actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))

        onView(withId(R.id.img_bg_detail))
                .check(matches(isDisplayed()))
        onView(withId(R.id.img_poster_detail))
                .check(matches(isDisplayed()))
        onView(withId(R.id.img_bg_movies))
                .check(matches(isDisplayed()))
        onView(withId(R.id.tv_title_detail))
                .check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre_detail))
                .check(matches(isDisplayed()))
        onView(withId(R.id.tv_release_date))
                .check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview))
                .check(matches(isDisplayed()))
    }

    @Test
    fun loadTvShows() {
        onView(withText("TV Show")).perform(ViewActions.click())
        onView(withId(R.id.rv_tvshow))
                .check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(tvShows.size))
    }

    @Test
    fun loadDetailTvShows() {
        onView(withText("TV Show")).perform(ViewActions.click())
        onView(withId(R.id.rv_tvshow)).perform(
                RecyclerViewActions
                        .actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))

        onView(withId(R.id.img_bg_detail))
                .check(matches(isDisplayed()))
        onView(withId(R.id.img_poster_detail))
                .check(matches(isDisplayed()))
        onView(withId(R.id.img_bg_movies))
                .check(matches(isDisplayed()))
        onView(withId(R.id.tv_title_detail))
                .check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre_detail))
                .check(matches(isDisplayed()))
        onView(withId(R.id.tv_release_date))
                .check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview))
                .check(matches(isDisplayed()))
    }

}