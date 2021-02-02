package com.dicoding.andikas.moviecatalogapp.view.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dicoding.andikas.moviecatalogapp.adapter.MovieAdapter
import com.dicoding.andikas.moviecatalogapp.databinding.FragmentTvShowBinding
import com.dicoding.andikas.moviecatalogapp.model.DataEntity
import com.dicoding.andikas.moviecatalogapp.view.DetailActivity
import com.dicoding.andikas.moviecatalogapp.viewmodel.TvShowViewModel

class TvShowFragment : Fragment() {

    companion object {
        const val TVSHOW_TYPE = "tvshow_type"
    }

    private var movieAdapter = MovieAdapter()
    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding
    private lateinit var tvShowViewModel: TvShowViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(inflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvShowViewModel = ViewModelProvider(activity!!, ViewModelProvider.NewInstanceFactory()).get(TvShowViewModel::class.java)

        movieAdapter.setData(tvShowViewModel.getTvShows())

        fragmentTvShowBinding.rvTvshow.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 2)
            adapter = movieAdapter
        }

        movieAdapter.setOnViewClickListener(object : MovieAdapter.ViewClickListener{
            override fun onClick(dataEntity: DataEntity) {
                Toast.makeText(context, dataEntity.title, Toast.LENGTH_SHORT).show()
                val intent = Intent(activity, DetailActivity::class.java)
                        .putExtra(DetailActivity.EXTRA_TITLE, dataEntity.title)
                        .putExtra(DetailActivity.EXTRA_ID, dataEntity.dataId)
                        .putExtra(DetailActivity.EXTRA_TYPE, TVSHOW_TYPE)
                startActivity(intent)
            }

        })
    }
}