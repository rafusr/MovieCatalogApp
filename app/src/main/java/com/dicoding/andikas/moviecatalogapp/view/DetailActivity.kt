package com.dicoding.andikas.moviecatalogapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.dicoding.andikas.moviecatalogapp.databinding.ActivityDetailBinding
import com.dicoding.andikas.moviecatalogapp.model.DataEntity
import com.dicoding.andikas.moviecatalogapp.view.fragment.MovieFragment
import com.dicoding.andikas.moviecatalogapp.view.fragment.TvShowFragment
import com.dicoding.andikas.moviecatalogapp.viewmodel.DetailViewModel

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_ID = "extra_id"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var activityDetailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(activityDetailBinding.root)

        val title = intent.getStringExtra(EXTRA_TITLE)
        supportActionBar?.title = title
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val detailViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(DetailViewModel::class.java)

        val dataId = intent.getStringExtra(EXTRA_ID)
        val dataType = intent.getStringExtra(EXTRA_TYPE)
        if (dataType == MovieFragment.MOVIE_TYPE){
            detailViewModel.setSelectedMovie(dataId.toString())
            setDetail(detailViewModel.getMovie())

        } else if(dataType == TvShowFragment.TVSHOW_TYPE){
            detailViewModel.setSelectedTvShow(dataId.toString())
            setDetail(detailViewModel.getTvShow())
        }
    }

    private fun setDetail(detail: DataEntity?){
        val title = detail?.title + detail?.releaseDate

        Glide.with(this).load(detail?.imgPoster).into(activityDetailBinding.imgBgDetail)
        Glide.with(this).load(detail?.imgPoster).into(activityDetailBinding.imgPosterDetail)
        Glide.with(this).load(detail?.imgBg).into(activityDetailBinding.imgBgMovies)
        activityDetailBinding.tvTitleDetail.text = title
        activityDetailBinding.tvGenreDetail.text = detail?.genre
        activityDetailBinding.tvOverview.text = detail?.overview
    }

}