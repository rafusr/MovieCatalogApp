package com.dicoding.andikas.moviecatalogapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow
import com.dicoding.andikas.moviecatalogapp.adapter.TvShowAdapter.TvShowViewHolder
import com.dicoding.andikas.moviecatalogapp.R
import com.dicoding.andikas.moviecatalogapp.vo.Resource
import kotlinx.android.synthetic.main.item_row.view.*

class TvShowAdapter(private val tvShows: Resource<List<TvShow>>) : RecyclerView.Adapter<TvShowViewHolder>() {

    companion object {
        private const val POSTER_URL = "https://image.tmdb.org/t/p/w500"
    }

    private lateinit var tvShowViewClickListener: TvShowViewClickListener

    fun setOnViewClickListener(tvShowViewClickListener: TvShowViewClickListener){
        this.tvShowViewClickListener = tvShowViewClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return TvShowViewHolder(view)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        tvShows.data?.get(position)?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int = tvShows.data?.size!!

    inner class TvShowViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(tvShow: TvShow){
            with(itemView){
                Glide.with(this)
                        .load(POSTER_URL + tvShow.poster_path).error(R.drawable.ic_baseline_broken_image_24).placeholder(R.drawable.ic_baseline_sync_24)
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