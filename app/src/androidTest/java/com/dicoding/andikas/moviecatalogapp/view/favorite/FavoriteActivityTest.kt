package com.dicoding.andikas.moviecatalogapp.view.favorite

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.GeneralLocation
import androidx.test.espresso.action.GeneralSwipeAction
import androidx.test.espresso.action.Press
import androidx.test.espresso.action.Swipe
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.dicoding.andikas.moviecatalogapp.R
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow
import com.dicoding.andikas.moviecatalogapp.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test

class FavoriteActivityTest {

    private val favMovies = ArrayList<Movie>()
    private val favTvShows = ArrayList<TvShow>()

    @Before
    fun setup() {
        ActivityScenario.launch(FavoriteActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @Test
    fun loadMovieFavorites() {
        onView(withId(R.id.rv_favorite_movie))
                .check(matches(isDisplayed()))
        onView(withId(R.id.rv_favorite_movie))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(favMovies.size))
        onView(withId(R.id.rv_favorite_movie))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, GeneralSwipeAction(
                        Swipe.FAST,
                        GeneralLocation.CENTER,
                        GeneralLocation.CENTER_RIGHT,
                        Press.FINGER
                )))

    }

    @Test
    fun loadTvShowsFavorites() {
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_favorite_tvshow))
                .check(matches(isDisplayed()))
        onView(withId(R.id.rv_favorite_tvshow))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(favTvShows.size))
        onView(withId(R.id.rv_favorite_tvshow))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, GeneralSwipeAction(
                        Swipe.FAST,
                        GeneralLocation.CENTER,
                        GeneralLocation.CENTER_RIGHT,
                        Press.FINGER
                )))
    }

}
