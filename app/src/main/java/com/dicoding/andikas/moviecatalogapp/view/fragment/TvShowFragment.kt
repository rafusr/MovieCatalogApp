package com.dicoding.andikas.moviecatalogapp.view.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dicoding.andikas.moviecatalogapp.view.DetailActivity
import com.dicoding.andikas.moviecatalogapp.viewmodel.TvShowViewModel
import com.dicoding.andikas.moviecatalogapp.viewmodel.ViewModelFactory
import com.dicoding.andikas.moviecatalogapp.R
import com.dicoding.andikas.moviecatalogapp.adapter.TvShowAdapter
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow
import kotlinx.android.synthetic.main.fragment_tv_show.*

class TvShowFragment : Fragment() {

    companion object {
        const val TVSHOW_TYPE = "tvshow_type"
    }

    private lateinit var tvShowAdapter: TvShowAdapter
    private lateinit var tvShowViewModel: TvShowViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progressBar(true)

        tvShowViewModel = activity?.let { ViewModelProvider(it, ViewModelFactory.getInstance()).get(TvShowViewModel::class.java) }!!
        tvShowViewModel.getTvShow().observe(this, {
            progressBar(false)
            recyclerViewConfig(it)
        })

        savedInstanceState?.putBundle("tv_show_state", savedInstanceState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        savedInstanceState?.getBundle("tv_show_state")
    }

    private fun recyclerViewConfig(listTvShow: List<TvShow>) {
        rv_tvshow.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity, 2)
            tvShowAdapter = TvShowAdapter(listTvShow)
            adapter = tvShowAdapter
        }

        tvShowAdapter.setOnViewClickListener(object : TvShowAdapter.TvShowViewClickListener{
            override fun onClick(tvShow: TvShow) {
                val intent = Intent(activity, DetailActivity::class.java)
                        .putExtra(DetailActivity.EXTRA_TITLE, tvShow.original_name)
                        .putExtra(DetailActivity.EXTRA_ID, tvShow.id.toString())
                        .putExtra(DetailActivity.EXTRA_TYPE, TVSHOW_TYPE)

                startActivity(intent)
            }

        })
    }

    private fun progressBar(state: Boolean) {
        if (state) {
            tvshow_progressbar.visibility = View.VISIBLE
        } else {
            tvshow_progressbar.visibility = View.GONE
        }
    }
}