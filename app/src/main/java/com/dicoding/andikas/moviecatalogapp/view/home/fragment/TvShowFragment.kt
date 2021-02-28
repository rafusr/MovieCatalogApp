package com.dicoding.andikas.moviecatalogapp.view.home.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.GridLayoutManager
import com.dicoding.andikas.moviecatalogapp.view.detail.DetailActivity
import com.dicoding.andikas.moviecatalogapp.viewmodel.TvShowViewModel
import com.dicoding.andikas.moviecatalogapp.viewmodel.ViewModelFactory
import com.dicoding.andikas.moviecatalogapp.R
import com.dicoding.andikas.moviecatalogapp.adapter.TvShowAdapter
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow
import com.dicoding.andikas.moviecatalogapp.vo.Status
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

        tvShowViewModel = activity?.let { ViewModelProvider(it, ViewModelFactory.getInstance(activity!!)).get(TvShowViewModel::class.java) }!!
        tvShowViewModel.getTvShow().observe(this, {
            if (it != null) {
                when (it.status) {
                    Status.LOADING -> progressBar(true)
                    Status.SUCCESS -> {
                        progressBar(false)
                        recyclerViewConfig(it.data)
                    }
                    Status.ERROR -> {
                        progressBar(false)
                        Toast.makeText(context, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    private fun recyclerViewConfig(listTvShow: PagedList<TvShow>?) {
        rv_tvshow.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity, 2)
            tvShowAdapter = TvShowAdapter()
            tvShowAdapter.submitList(listTvShow)
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