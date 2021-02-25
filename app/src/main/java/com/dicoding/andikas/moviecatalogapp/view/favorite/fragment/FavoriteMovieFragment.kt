package com.dicoding.andikas.moviecatalogapp.view.favorite.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dicoding.andikas.moviecatalogapp.R
import com.dicoding.andikas.moviecatalogapp.adapter.FavoriteMovieAdapter
import com.dicoding.andikas.moviecatalogapp.adapter.MovieAdapter
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.dicoding.andikas.moviecatalogapp.view.detail.DetailActivity
import com.dicoding.andikas.moviecatalogapp.view.home.fragment.MovieFragment
import com.dicoding.andikas.moviecatalogapp.viewmodel.FavoriteMovieViewModel
import com.dicoding.andikas.moviecatalogapp.viewmodel.ViewModelFactory
import com.dicoding.andikas.moviecatalogapp.vo.Resource
import kotlinx.android.synthetic.main.fragment_favorite_movie.*
import kotlinx.android.synthetic.main.fragment_movie.*

class FavoriteMovieFragment : Fragment() {

    companion object {
        const val FAVORITE_MOVIE_TYPE = "movie_type"
    }

    private lateinit var favoriteMovieAdapter: FavoriteMovieAdapter
    private lateinit var favoriteMovieViewModel: FavoriteMovieViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progressBar(true)
        favoriteMovieViewModel = activity?.let { ViewModelProvider(it, ViewModelFactory.getInstance(activity!!))[FavoriteMovieViewModel::class.java] }!!
        favoriteMovieViewModel.getFavoriteMovie().observe(this, {
            progressBar(false)
            if (it != null) {
                recyclerViewConfig(it)
            }
        })
    }

    private fun recyclerViewConfig(listMovie: List<Movie>) {
        rv_favorite_movie.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity, 2)
            favoriteMovieAdapter = FavoriteMovieAdapter(listMovie)
            adapter = favoriteMovieAdapter
        }

        favoriteMovieAdapter.setOnViewClickListener(object : FavoriteMovieAdapter.FavoriteMovieViewClickListener{
            override fun onClick(movie: Movie) {
                val intent = Intent(activity, DetailActivity::class.java)
                    .putExtra(DetailActivity.EXTRA_TITLE, movie.original_title)
                    .putExtra(DetailActivity.EXTRA_ID, movie.id.toString())
                    .putExtra(DetailActivity.EXTRA_TYPE, FAVORITE_MOVIE_TYPE)

                startActivity(intent)
            }

        })
    }

    private fun progressBar(state: Boolean) {
        if (state) {
            favorite_movie_progressbar.visibility = View.VISIBLE
        } else {
            favorite_movie_progressbar.visibility = View.GONE
        }
    }

}