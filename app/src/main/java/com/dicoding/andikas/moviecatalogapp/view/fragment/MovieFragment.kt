package com.dicoding.andikas.moviecatalogapp.view.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dicoding.andikas.moviecatalogapp.adapter.MovieAdapter
import com.dicoding.andikas.moviecatalogapp.databinding.FragmentMovieBinding
import com.dicoding.andikas.moviecatalogapp.model.DataEntity
import com.dicoding.andikas.moviecatalogapp.view.DetailActivity
import com.dicoding.andikas.moviecatalogapp.viewmodel.MovieViewModel

class MovieFragment : Fragment() {

    companion object {
        const val MOVIE_TYPE = "movie_type"
    }

    private var movieAdapter = MovieAdapter()
    private lateinit var fragmentMovieBinding: FragmentMovieBinding
    private lateinit var movieViewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        fragmentMovieBinding = FragmentMovieBinding.inflate(inflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieViewModel = ViewModelProvider(activity!!, ViewModelProvider.NewInstanceFactory()).get(MovieViewModel::class.java)

        movieAdapter.setData(movieViewModel.getMovies())

        fragmentMovieBinding.rvMovie.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 2)
            adapter = movieAdapter
        }

        movieAdapter.setOnViewClickListener(object : MovieAdapter.ViewClickListener{
            override fun onClick(dataEntity: DataEntity) {
                Toast.makeText(context, dataEntity.title, Toast.LENGTH_SHORT).show()
                val intent = Intent(activity, DetailActivity::class.java)
                        .putExtra(DetailActivity.EXTRA_TITLE, dataEntity.title)
                        .putExtra(DetailActivity.EXTRA_ID, dataEntity.dataId)
                        .putExtra(DetailActivity.EXTRA_TYPE, MOVIE_TYPE)
                startActivity(intent)
            }

        })
    }
}