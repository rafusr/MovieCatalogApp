package com.dicoding.andikas.moviecatalogapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow
import com.dicoding.andikas.moviecatalogapp.adapter.TvShowAdapter.TvShowViewHolder
import com.dicoding.andikas.moviecatalogapp.R
import kotlinx.android.synthetic.main.item_row.view.*

class TvShowAdapter(private val tvShows: List<TvShow>) : RecyclerView.Adapter<TvShowViewHolder>() {

    private lateinit var tvShowViewClickListener: TvShowViewClickListener

    fun setOnViewClickListener(tvShowViewClickListener: TvShowViewClickListener){
        this.tvShowViewClickListener = tvShowViewClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return TvShowViewHolder(view)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(tvShows[position])
    }

    override fun getItemCount(): Int = tvShows.size

    inner class TvShowViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(tvShow: TvShow){
            with(itemView){
                Glide.with(this)
                        .load("https://image.tmdb.org/t/p/w500${tvShow.poster_path}").error(R.drawable.background_tabs)
                        .into(img_poster)

                tv_title.text = tvShow.original_name
            }
            itemView.setOnClickListener{
                tvShowViewClickListener.onClick(tvShow)
            }
        }
    }

    interface TvShowViewClickListener{
        fun onClick(tvShow: TvShow)
    }

}