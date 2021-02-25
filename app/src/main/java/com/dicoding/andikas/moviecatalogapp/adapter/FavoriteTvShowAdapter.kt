package com.dicoding.andikas.moviecatalogapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.andikas.moviecatalogapp.R
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow
import kotlinx.android.synthetic.main.item_row.view.*

class FavoriteTvShowAdapter : PagedListAdapter<TvShow, FavoriteTvShowAdapter.FavoriteTvShowViewHolder>(
    DIFF_CALLBACK) {

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

    private lateinit var favoriteTvShowViewClickListener: FavoriteTvShowViewClickListener

    fun setOnViewClickListener(favoriteTvShowViewClickListener: FavoriteTvShowViewClickListener){
        this.favoriteTvShowViewClickListener = favoriteTvShowViewClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteTvShowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return FavoriteTvShowViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteTvShowViewHolder, position: Int) {
        val favTvShow = getItem(position)
        if (favTvShow != null) {
            holder.bind(favTvShow)
        }
    }

    fun getSwipedData(swipedPosition: Int): TvShow? = getItem(swipedPosition)

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