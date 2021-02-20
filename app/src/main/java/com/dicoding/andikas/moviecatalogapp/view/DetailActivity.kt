package com.dicoding.andikas.moviecatalogapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.dicoding.andikas.moviecatalogapp.view.fragment.MovieFragment
import com.dicoding.andikas.moviecatalogapp.view.fragment.TvShowFragment
import com.dicoding.andikas.moviecatalogapp.viewmodel.DetailViewModel
import com.dicoding.andikas.moviecatalogapp.viewmodel.ViewModelFactory
import com.dicoding.andikas.moviecatalogapp.R
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_ID = "extra_id"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var detailViewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val title = intent.getStringExtra(EXTRA_TITLE)
        supportActionBar?.title = title
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        progressBar(true)

        detailViewModel = ViewModelProvider(this, ViewModelFactory.getInstance()).get(DetailViewModel::class.java)

        val dataId = intent.getStringExtra(EXTRA_ID)
        val dataType = intent.getStringExtra(EXTRA_TYPE)
        if (dataType == MovieFragment.MOVIE_TYPE){
            detailViewModel.getMovieDetail(dataId.toString()).observe(this, {
                progressBar(false)
                setMovieDetail(it)
            })

        } else if(dataType == TvShowFragment.TVSHOW_TYPE){
            detailViewModel.getTvShowDetail(dataId.toString()).observe(this, {
                progressBar(false)
                setTvShowDetail(it)
            })
        }
    }

    private fun setMovieDetail(movie: Movie?) {
        val backdropPath = "https://image.tmdb.org/t/p/w500" + movie?.backdrop_path.toString()
        val posterPath = "https://image.tmdb.org/t/p/w500" + movie?.poster_path.toString()

        Glide.with(this)
                .load(posterPath).error(R.drawable.ic_baseline_broken_image_24).placeholder(R.drawable.ic_baseline_sync_24)
                .into(img_bg_detail)
        Glide.with(this)
                .load(posterPath).error(R.drawable.ic_baseline_broken_image_24).placeholder(R.drawable.ic_baseline_sync_24)
                .into(img_poster_detail)
        Glide.with(this)
                .load(backdropPath).error(R.drawable.ic_baseline_broken_image_24).placeholder(R.drawable.ic_baseline_sync_24)
                .into(img_bg_movies)
        tv_title_detail.text = movie?.original_title
        tv_genre_detail.text = movie?.genres?.get(0)?.name
        tv_release_date.text = movie?.release_date
        tv_overview.text = movie?.overview
    }

    private fun setTvShowDetail(tvShow: TvShow?) {
        val backdropPath = "https://image.tmdb.org/t/p/w500" + tvShow?.backdrop_path.toString()
        val posterPath = "https://image.tmdb.org/t/p/w500" + tvShow?.poster_path.toString()

        Glide.with(this)
                .load(posterPath).error(R.drawable.ic_baseline_broken_image_24).placeholder(R.drawable.ic_baseline_sync_24)
                .into(img_bg_detail)
        Glide.with(this)
                .load(posterPath).error(R.drawable.ic_baseline_broken_image_24).placeholder(R.drawable.ic_baseline_sync_24)
                .into(img_poster_detail)
        Glide.with(this)
                .load(backdropPath).error(R.drawable.ic_baseline_broken_image_24).placeholder(R.drawable.ic_baseline_sync_24)
                .into(img_bg_movies)
        tv_title_detail.text = tvShow?.original_name
        tv_genre_detail.text = tvShow?.genres?.get(0)?.name
        tv_release_date.text = tvShow?.first_air_date
        tv_overview.text = tvShow?.overview
    }

    private fun progressBar(state: Boolean) {
        if (state) {
            detail_progressbar.visibility = View.VISIBLE
        } else {
            detail_progressbar.visibility = View.GONE
        }
    }
}