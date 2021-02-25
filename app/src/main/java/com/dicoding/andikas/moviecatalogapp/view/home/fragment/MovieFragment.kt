package com.dicoding.andikas.moviecatalogapp.view.home.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dicoding.andikas.moviecatalogapp.viewmodel.MovieViewModel
import com.dicoding.andikas.moviecatalogapp.viewmodel.ViewModelFactory
import com.dicoding.andikas.moviecatalogapp.view.detail.DetailActivity
import com.dicoding.andikas.moviecatalogapp.R
import com.dicoding.andikas.moviecatalogapp.adapter.MovieAdapter
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.dicoding.andikas.moviecatalogapp.vo.Resource
import com.dicoding.andikas.moviecatalogapp.vo.Status
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment() {

    companion object {
        const val MOVIE_TYPE = "movie_type"
        const val EXTRA_MAIN_ACTIVITY = "extra_main_activity"
    }

    private lateinit var movieAdapter: MovieAdapter
    private lateinit var movieViewModel: MovieViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieViewModel = activity?.let { ViewModelProvider(it, ViewModelFactory.getInstance(activity!!)).get(MovieViewModel::class.java) }!!
        movieViewModel.getMovie().observe(this, {
            if (it != null) {
                when (it.status) {
                    Status.LOADING -> progressBar(true)
                    Status.SUCCESS -> {
                        progressBar(false)
                        recyclerViewConfig(it)
                    }
                    Status.ERROR -> {
                        progressBar(false)
                        Toast.makeText(context, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    private fun recyclerViewConfig(listMovie: Resource<List<Movie>>) {
        rv_movie.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity, 2)
            movieAdapter = MovieAdapter(listMovie)
            adapter = movieAdapter
        }

        movieAdapter.setOnViewClickListener(object : MovieAdapter.MovieViewClickListener{
            override fun onClick(movie: Movie) {
                val intent = Intent(activity, DetailActivity::class.java)
                        .putExtra(DetailActivity.EXTRA_TITLE, movie.original_title)
                        .putExtra(DetailActivity.EXTRA_ID, movie.id.toString())
                        .putExtra(DetailActivity.EXTRA_TYPE, MOVIE_TYPE)
                        .putExtra(DetailActivity.EXTRA_ACTIVITY, EXTRA_MAIN_ACTIVITY)

                startActivity(intent)
            }

        })
    }

    private fun progressBar(state: Boolean) {
        if (state) {
            movie_progressbar.visibility = View.VISIBLE
        } else {
            movie_progressbar.visibility = View.GONE
        }
    }

}