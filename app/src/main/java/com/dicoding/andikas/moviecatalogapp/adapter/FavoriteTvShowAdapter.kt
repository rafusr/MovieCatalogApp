package com.dicoding.andikas.moviecatalogapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.andikas.moviecatalogapp.R
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow
import kotlinx.android.synthetic.main.item_row.view.*

class FavoriteTvShowAdapter(private val tvShows : List<TvShow>) : RecyclerView.Adapter<FavoriteTvShowAdapter.FavoriteTvShowViewHolder>() {

    companion object {
        private const val POSTER_URL = "https://image.tmdb.org/t/p/w500"
    }

    private lateinit var favoriteTvShowViewClickListener: FavoriteTvShowViewClickListener

    fun setOnViewClickListener(favoriteTvShowViewClickListener: FavoriteTvShowViewClickListener){
        this.favoriteTvShowViewClickListener = favoriteTvShowViewClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteTvShowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return FavoriteTvShowViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteTvShowViewHolder, position: Int) {
        holder.bind(tvShows[position])
    }

    override fun getItemCount(): Int = tvShows.size

    inner class FavoriteTvShowViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(tvShow: TvShow){
            with(itemView){
                Glide.with(this)
                        .load(POSTER_URL + tvShow.poster_path).error(R.drawable.ic_baseline_broken_image_24).placeholder(R.drawable.ic_baseline_sync_24)
                        .into(img_poster)

                tv_title.text = tvShow.original_name
            }
            itemView.setOnClickListener{
                favoriteTvShowViewClickListener.onClick(tvShow)
            }
        }
    }

    interface FavoriteTvShowViewClickListener{
        fun onClick(tvShow: TvShow)
    }
}