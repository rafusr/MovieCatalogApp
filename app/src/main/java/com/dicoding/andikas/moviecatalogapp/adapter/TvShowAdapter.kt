package com.dicoding.andikas.moviecatalogapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow
import com.dicoding.andikas.moviecatalogapp.adapter.TvShowAdapter.TvShowViewHolder
import com.dicoding.andikas.moviecatalogapp.R
import kotlinx.android.synthetic.main.item_row.view.*

class TvShowAdapter : PagedListAdapter<TvShow, TvShowViewHolder>(DIFF_CALLBACK) {

    companion object {
        private const val POSTER_URL = "https://image.tmdb.org/t/p/w500"

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShow>() {
            override fun areItemsTheSame(oldItem: TvShow, newItem: TvShow): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TvShow, newItem: TvShow): Boolean {
                return oldItem == newItem
            }

        }
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
        val tvShow = getItem(position)
        if (tvShow != null) {
            holder.bind(tvShow)
        }
    }

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