package com.dicoding.andikas.moviecatalogapp.view.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import com.dicoding.andikas.moviecatalogapp.R
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow
import com.dicoding.andikas.moviecatalogapp.utils.EspressoIdlingResource
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
        Espresso.onView(ViewMatchers.withId(R.id.rv_movie))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rv_movie))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(movies.size))
    }

    @Test
    fun loadDetailMovies() {
        Espresso.onView(ViewMatchers.withId(R.id.rv_movie)).perform(
                RecyclerViewActions
                        .actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))

        Espresso.onView(ViewMatchers.withId(R.id.img_bg_detail))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.img_poster_detail))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.img_bg_movies))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tv_title_detail))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tv_release_date))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tv_overview))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.btn_favorite))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.btn_favorite))
                .perform(ViewActions.click())
    }

    @Test
    fun loadTvShows() {
        Espresso.onView(ViewMatchers.withText("TV Show")).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.rv_tvshow))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rv_tvshow))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(tvShows.size))
    }

    @Test
    fun loadDetailTvShows() {
        Espresso.onView(ViewMatchers.withText("TV Show")).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.rv_tvshow)).perform(
                RecyclerViewActions
                        .actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))

        Espresso.onView(ViewMatchers.withId(R.id.img_bg_detail))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.img_poster_detail))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.img_bg_movies))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tv_title_detail))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tv_release_date))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tv_overview))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.btn_favorite))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.btn_favorite))
                .perform(ViewActions.click())
    }

}