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
import com.dicoding.andikas.moviecatalogapp.adapter.FavoriteTvShowAdapter
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow
import com.dicoding.andikas.moviecatalogapp.view.detail.DetailActivity
import com.dicoding.andikas.moviecatalogapp.viewmodel.FavoriteTvShowViewModel
import com.dicoding.andikas.moviecatalogapp.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_favorite_tv_show.*

class FavoriteTvShowFragment : Fragment() {

    companion object {
        const val FAVORITE_TVSHOW_TYPE = "tvshow_type"
    }

    private lateinit var favoriteTvShowAdapter: FavoriteTvShowAdapter
    private lateinit var favoriteTvShowViewModel: FavoriteTvShowViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_tv_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(rv_favorite_tvshow)

        progressBar(true)
        favoriteTvShowViewModel = activity?.let { ViewModelProvider(it, ViewModelFactory.getInstance(activity!!))[FavoriteTvShowViewModel::class.java] }!!
        favoriteTvShowViewModel.getFavoriteTvShow().observe(this, {
            progressBar(false)
            if (it != null) {
                recyclerViewConfig(it)
            }
        })
    }

    private fun recyclerViewConfig(listTvShow: PagedList<TvShow>) {
        rv_favorite_tvshow.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity, 2)
            favoriteTvShowAdapter = FavoriteTvShowAdapter()
            favoriteTvShowAdapter.submitList(listTvShow)
            adapter = favoriteTvShowAdapter
        }

        favoriteTvShowAdapter.setOnViewClickListener(object : FavoriteTvShowAdapter.FavoriteTvShowViewClickListener{
            override fun onClick(tvShow: TvShow) {
                val intent = Intent(activity, DetailActivity::class.java)
                        .putExtra(DetailActivity.EXTRA_TITLE, tvShow.original_name)
                        .putExtra(DetailActivity.EXTRA_ID, tvShow.id.toString())
                        .putExtra(DetailActivity.EXTRA_TYPE, FAVORITE_TVSHOW_TYPE)

                startActivity(intent)
            }

        })
    }

    private fun progressBar(state: Boolean) {
        if (state) {
            favorite_tvshow_progressbar.visibility = View.VISIBLE
        } else {
            favorite_tvshow_progressbar.visibility = View.GONE
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
                val tvShow = favoriteTvShowAdapter.getSwipedData(swipedPosition)
                tvShow?.let { favoriteTvShowViewModel.setFavorite(it) }

                val snackbar = Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_SHORT)
                snackbar.setAction(R.string.message_ok) { _ ->
                    tvShow?.let { favoriteTvShowViewModel.setFavorite(it) }
                }
                snackbar.show()
            }
        }

    })
}