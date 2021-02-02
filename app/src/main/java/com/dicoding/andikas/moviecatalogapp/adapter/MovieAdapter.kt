package com.dicoding.andikas.moviecatalogapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.andikas.moviecatalogapp.model.DataEntity
import com.dicoding.andikas.moviecatalogapp.R
import kotlinx.android.synthetic.main.item_row.view.*

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private val dataEntity = ArrayList<DataEntity>()
    private lateinit var viewClickListener: ViewClickListener

    fun setData(dataEntities: List<DataEntity>){
        this.dataEntity.clear()
        this.dataEntity.addAll(dataEntities)
    }

    fun setOnViewClickListener(viewClickListener: ViewClickListener){
        this.viewClickListener = viewClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(dataEntity[position])
    }

    override fun getItemCount(): Int = dataEntity.size

    inner class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(dataEntity: DataEntity){
            with(itemView){
                Glide.with(this).load(dataEntity.imgPoster).into(img_poster)
                tv_title.text = dataEntity.title
            }
            itemView.setOnClickListener{
                viewClickListener.onClick(dataEntity)
            }
        }
    }

    interface ViewClickListener{
        fun onClick(dataEntity: DataEntity)
    }

}