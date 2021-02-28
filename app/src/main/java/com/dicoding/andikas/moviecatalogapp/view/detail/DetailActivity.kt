package com.dicoding.andikas.moviecatalogapp.view.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.dicoding.andikas.moviecatalogapp.R
import com.dicoding.andikas.moviecatalogapp.databinding.ActivityDetailBinding
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow
import com.dicoding.andikas.moviecatalogapp.viewmodel.DetailViewModel
import com.dicoding.andikas.moviecatalogapp.viewmodel.ViewModelFactory
import com.dicoding.andikas.moviecatalogapp.vo.Resource
import com.dicoding.andikas.moviecatalogapp.vo.Status

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_ID = "extra_id"
        const val EXTRA_TYPE = "extra_type"

        const val BACKDROP_PATH_URL = "https://image.tmdb.org/t/p/w500"
        const val POSTER_PATH_URL = "https://image.tmdb.org/t/p/w500"
    }

    private lateinit var detailViewModel: DetailViewModel
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
                    .into(binding.imgBgDetail)
            Glide.with(this)
                    .load(posterPath).error(R.drawable.ic_baseline_broken_image_24).placeholder(R.drawable.ic_baseline_sync_24)
                    .into(binding.imgPosterDetail)
            Glide.with(this)
                    .load(backdropPath).error(R.drawable.ic_baseline_broken_image_24).placeholder(R.drawable.ic_baseline_sync_24)
                    .into(binding.imgBgMovies)
            binding.tvTitleDetail.text = movie.original_title
            binding.tvReleaseDate.text = movie.release_date
            binding.tvOverview.text = movie.overview

            binding.btnFavorite.setOnClickListener {
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
                    .into(binding.imgBgDetail)
            Glide.with(this)
                    .load(posterPath).error(R.drawable.ic_baseline_broken_image_24).placeholder(R.drawable.ic_baseline_sync_24)
                    .into(binding.imgPosterDetail)
            Glide.with(this)
                    .load(backdropPath).error(R.drawable.ic_baseline_broken_image_24).placeholder(R.drawable.ic_baseline_sync_24)
                    .into(binding.imgBgMovies)
            binding.tvTitleDetail.text = tvShow.original_name
            binding.tvReleaseDate.text = tvShow.first_air_date
            binding.tvOverview.text = tvShow.overview

            binding.btnFavorite.setOnClickListener {
                setFavoriteState(!state)
                detailViewModel.setTvShowFavorite()
            }
        }


    }

    private fun setFavoriteState(state: Boolean){
        if (state){
            binding.btnFavorite.setBackgroundResource(R.drawable.ic_baseline_favorite_24)
        } else {
            binding.btnFavorite.setBackgroundResource(R.drawable.ic_baseline_favorite_border_24)
        }
    }

    private fun progressBar(state: Boolean) {
        if (state) {
            binding.detailProgressbar.visibility = View.VISIBLE
        } else {
            binding.detailProgressbar.visibility = View.GONE
        }
    }

}