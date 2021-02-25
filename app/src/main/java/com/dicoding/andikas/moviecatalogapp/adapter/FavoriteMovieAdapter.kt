package com.dicoding.andikas.moviecatalogapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.andikas.moviecatalogapp.R
import com.dicoding.andikas.moviecatalogapp.adapter.FavoriteMovieAdapter.*
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import kotlinx.android.synthetic.main.item_row.view.*

class FavoriteMovieAdapter : PagedListAdapter<Movie, FavoriteMovieViewHolder>(DIFF_CALLBACK) {

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

    private lateinit var favoriteMovieViewClickListener: FavoriteMovieViewClickListener

    fun setOnViewClickListener(favoriteMovieViewClickListener: FavoriteMovieViewClickListener){
        this.favoriteMovieViewClickListener = favoriteMovieViewClickListener
    }

    fun getSwipedData(swipedPosition: Int): Movie? = getItem(swipedPosition)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return FavoriteMovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteMovieViewHolder, position: Int) {
        val favMovie = getItem(position)
        if (favMovie != null) {
            holder.bind(favMovie)
        }
    }

    inner class FavoriteMovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(movie : Movie){
            with(itemView){
                Glide.with(this)
                        .load(POSTER_URL + movie.poster_path).error(R.drawable.ic_baseline_broken_image_24).placeholder(R.drawable.ic_baseline_sync_24)
                        .into(img_poster)

                tv_title.text = movie.original_title
            }
            itemView.setOnClickListener{
                favoriteMovieViewClickListener.onClick(movie)
            }
        }
    }

    interface FavoriteMovieViewClickListener{
        fun onClick(movie: Movie)
    }
}