package com.dicoding.andikas.moviecatalogapp.view.favorite.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.andikas.moviecatalogapp.R
import com.dicoding.andikas.moviecatalogapp.adapter.FavoriteMovieAdapter
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.dicoding.andikas.moviecatalogapp.view.detail.DetailActivity
import com.dicoding.andikas.moviecatalogapp.viewmodel.FavoriteMovieViewModel
import com.dicoding.andikas.moviecatalogapp.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_favorite_movie.*

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
        itemTouchHelper.attachToRecyclerView(rv_favorite_movie)

        progressBar(true)
        favoriteMovieViewModel = activity?.let { ViewModelProvider(it, ViewModelFactory.getInstance(activity!!))[FavoriteMovieViewModel::class.java] }!!
        favoriteMovieViewModel.getFavoriteMovie().observe(this, {
            progressBar(false)
            if (it != null) {
                recyclerViewConfig(it)
            }
        })
    }

    private fun recyclerViewConfig(listMovie: PagedList<Movie>) {
        rv_favorite_movie.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity, 2)
            favoriteMovieAdapter = FavoriteMovieAdapter()
            favoriteMovieAdapter.submitList(listMovie)
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
    
    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val movie = favoriteMovieAdapter.getSwipedData(swipedPosition)
                movie?.let { favoriteMovieViewModel.setFavorite(it) }

                val snackbar = Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_SHORT)
                snackbar.setAction(R.string.message_ok) { _ ->
                    movie?.let { favoriteMovieViewModel.setFavorite(it) }
                }
                snackbar.show()
            }
        }

    })

}