package com.dicoding.andikas.moviecatalogapp.adapter

import android.content.Context
import androidx.annotation.Nullable
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dicoding.andikas.moviecatalogapp.R
import com.dicoding.andikas.moviecatalogapp.view.favorite.fragment.FavoriteMovieFragment
import com.dicoding.andikas.moviecatalogapp.view.favorite.fragment.FavoriteTvShowFragment

class FavoriteSectionPagerAdapter(private val context: Context, fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    @StringRes
    private val tabTitles = intArrayOf(R.string.movie, R.string.tvshow)

    @Nullable
    override fun getPageTitle(position: Int): CharSequence {
        return context.resources.getString(tabTitles[position])
    }

    override fun getCount(): Int = tabTitles.size

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = FavoriteMovieFragment()
            1 -> fragment = FavoriteTvShowFragment()
        }
        return fragment as Fragment
    }
}