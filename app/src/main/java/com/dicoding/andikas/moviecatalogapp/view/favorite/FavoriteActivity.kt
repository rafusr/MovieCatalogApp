package com.dicoding.andikas.moviecatalogapp.view.favorite

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.andikas.moviecatalogapp.R
import com.dicoding.andikas.moviecatalogapp.adapter.FavoriteSectionPagerAdapter
import com.dicoding.andikas.moviecatalogapp.databinding.ActivityFavoriteBinding
import com.dicoding.andikas.moviecatalogapp.view.home.MainActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Favorite"

        binding.favoriteViewpager.adapter =
            FavoriteSectionPagerAdapter(this, supportFragmentManager)
        binding.favoriteTab.setupWithViewPager(binding.favoriteViewpager)
        supportActionBar?.elevation = 0f

        binding.favoriteBottomNav.selectedItemId = R.id.favorites_nav
        binding.favoriteBottomNav.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home_nav -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.favorites_nav -> return@OnNavigationItemSelectedListener true
            }
            true
        })
    }

    override fun onRestart() {
        super.onRestart()
        finish()
        startActivity(intent)
    }
}