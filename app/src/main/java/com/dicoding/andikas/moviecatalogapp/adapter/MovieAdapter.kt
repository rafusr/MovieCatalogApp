package com.dicoding.andikas.moviecatalogapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.dicoding.andikas.moviecatalogapp.adapter.MovieAdapter.MovieViewHolder
import com.dicoding.andikas.moviecatalogapp.R
import kotlinx.android.synthetic.main.item_row.view.*

class MovieAdapter : PagedListAdapter<Movie, MovieViewHolder>(DIFF_CALLBACK) {

    companion object {
        private const val POSTER_URL = "https://image.tmdb.org/t/p/w500"

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }

        }
    }

    private lateinit var movieViewClickListener: MovieViewClickListener

    fun setOnViewClickListener(movieViewClickListener: MovieViewClickListener){
        this.movieViewClickListener = movieViewClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie)
        }
    }

    inner class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(movie : Movie){
            with(itemView){
                Glide.with(this)
                        .load(POSTER_URL + movie.poster_path).error(R.drawable.ic_baseline_broken_image_24).placeholder(R.drawable.ic_baseline_sync_24)
                        .into(img_poster)

                tv_title.text = movie.original_title
            }
            itemView.setOnClickListener{
                movieViewClickListener.onClick(movie)
            }
        }
    }

    interface MovieViewClickListener{
        fun onClick(movie: Movie)
    }

}