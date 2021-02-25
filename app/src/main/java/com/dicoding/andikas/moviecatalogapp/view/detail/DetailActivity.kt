package com.dicoding.andikas.moviecatalogapp.view.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.dicoding.andikas.moviecatalogapp.viewmodel.DetailViewModel
import com.dicoding.andikas.moviecatalogapp.viewmodel.ViewModelFactory
import com.dicoding.andikas.moviecatalogapp.R
import com.dicoding.andikas.moviecatalogapp.adapter.SectionPagerAdapter
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow
import com.dicoding.andikas.moviecatalogapp.vo.Resource
import com.dicoding.andikas.moviecatalogapp.vo.Status
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_favorite.*
import kotlinx.android.synthetic.main.activity_main.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_ID = "extra_id"
        const val EXTRA_TYPE = "extra_type"
        const val EXTRA_ACTIVITY = "extra_activity"

        const val BACKDROP_PATH_URL = "https://image.tmdb.org/t/p/w500"
        const val POSTER_PATH_URL = "https://image.tmdb.org/t/p/w500"
    }

    private lateinit var detailViewModel: DetailViewModel
    private val mainViewPager = R.id.main_viewpager
    private val favViewPager = R.id.favorite_viewpager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val title = intent.getStringExtra(EXTRA_TITLE)
        supportActionBar?.title = title
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        detailViewModel = ViewModelProvider(this, ViewModelFactory.getInstance(this)).get(DetailViewModel::class.java)

        val dataId = intent.getStringExtra(EXTRA_ID)
        val dataType = intent.getStringExtra(EXTRA_TYPE)
        if (dataId != null) {
            if (dataType == "movie_type"){
                detailViewModel.selectedMovie(dataId)
                detailViewModel.movies.observe(this, {
                    if (it != null) {
                        when (it.status) {
                            Status.LOADING -> progressBar(true)
                            Status.SUCCESS -> {
                                progressBar(false)
                                setMovieDetail(it)
                            }
                            Status.ERROR -> {
                                progressBar(false)
                                Toast.makeText(this, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })

            } else if(dataType == "tvshow_type"){
                detailViewModel.selectedTvShow(dataId)
                detailViewModel.tvShows.observe(this, {
                    if (it != null) {
                        when (it.status) {
                            Status.LOADING -> progressBar(true)
                            Status.SUCCESS -> {
                                progressBar(false)
                                setTvShowDetail(it)
                            }
                            Status.ERROR -> {
                                progressBar(false)
                                Toast.makeText(this, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })
            }
        }

    }

    private fun setMovieDetail(mMovie: Resource<Movie>) {
        val movie = mMovie.data

        if (movie != null) {
            val backdropPath = BACKDROP_PATH_URL + movie.backdrop_path
            val posterPath = POSTER_PATH_URL + movie.poster_path
            val state = movie.favorited
            setFavoriteState(state)

            Glide.with(this)
                    .load(posterPath).error(R.drawable.ic_baseline_broken_image_24).placeholder(R.drawable.ic_baseline_sync_24)
                    .into(img_bg_detail)
            Glide.with(this)
                    .load(posterPath).error(R.drawable.ic_baseline_broken_image_24).placeholder(R.drawable.ic_baseline_sync_24)
                    .into(img_poster_detail)
            Glide.with(this)
                    .load(backdropPath).error(R.drawable.ic_baseline_broken_image_24).placeholder(R.drawable.ic_baseline_sync_24)
                    .into(img_bg_movies)
            tv_title_detail.text = movie.original_title
            tv_genre_detail.text = movie.genres?.get(0)?.name
            tv_release_date.text = movie.release_date
            tv_overview.text = movie.overview

            btn_favorite.setOnClickListener {
                setFavoriteState(!state)
                detailViewModel.setMovieFavorite()
            }
        }

    }

    private fun setTvShowDetail(mTvShow: Resource<TvShow>) {
        val tvShow = mTvShow.data
        if (tvShow != null) {
            val backdropPath = BACKDROP_PATH_URL + tvShow.backdrop_path
            val posterPath = POSTER_PATH_URL + tvShow.poster_path
            val state = tvShow.favorited
            setFavoriteState(state)

            Glide.with(this)
                    .load(posterPath).error(R.drawable.ic_baseline_broken_image_24).placeholder(R.drawable.ic_baseline_sync_24)
                    .into(img_bg_detail)
            Glide.with(this)
                    .load(posterPath).error(R.drawable.ic_baseline_broken_image_24).placeholder(R.drawable.ic_baseline_sync_24)
                    .into(img_poster_detail)
            Glide.with(this)
                    .load(backdropPath).error(R.drawable.ic_baseline_broken_image_24).placeholder(R.drawable.ic_baseline_sync_24)
                    .into(img_bg_movies)
            tv_title_detail.text = tvShow.original_name
            tv_genre_detail.text = tvShow.genres?.get(0)?.name
            tv_release_date.text = tvShow.first_air_date
            tv_overview.text = tvShow.overview

            btn_favorite.setOnClickListener {
                setFavoriteState(!state)
                detailViewModel.setTvShowFavorite()
            }
        }


    }

    private fun setFavoriteState(state: Boolean){
        if (state){
            btn_favorite.setBackgroundResource(R.drawable.ic_baseline_favorite_24)
        } else {
            btn_favorite.setBackgroundResource(R.drawable.ic_baseline_favorite_border_24)
        }
    }

    private fun progressBar(state: Boolean) {
        if (state) {
            detail_progressbar.visibility = View.VISIBLE
        } else {
            detail_progressbar.visibility = View.GONE
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val dataActivity = intent.getStringExtra(EXTRA_ACTIVITY)
        if (dataActivity == "extra_main_activity") {
            main_viewpager.currentItem
        } else if (dataActivity == "extra_favorite_activity") {
            favorite_viewpager.currentItem
        }
    }

}