package com.dicoding.andikas.moviecatalogapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.dicoding.andikas.moviecatalogapp.adapter.MovieAdapter.MovieViewHolder
import com.dicoding.andikas.moviecatalogapp.R
import kotlinx.android.synthetic.main.item_row.view.*

class MovieAdapter(private val movies : List<Movie>) : RecyclerView.Adapter<MovieViewHolder>() {

    private lateinit var movieViewClickListener: MovieViewClickListener

    fun setOnViewClickListener(movieViewClickListener: MovieViewClickListener){
        this.movieViewClickListener = movieViewClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size

    inner class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(movie : Movie){
            with(itemView){
                Glide.with(this)
                        .load("https://image.tmdb.org/t/p/w500${movie.poster_path}").error(R.drawable.background_tabs)
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