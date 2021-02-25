package com.dicoding.andikas.moviecatalogapp.view.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.andikas.moviecatalogapp.R
import com.dicoding.andikas.moviecatalogapp.adapter.SectionPagerAdapter
import com.dicoding.andikas.moviecatalogapp.databinding.ActivityMainBinding
import com.dicoding.andikas.moviecatalogapp.view.favorite.FavoriteActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val sectionPagerAdapter = SectionPagerAdapter(this, supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Movie Catalogue"

        binding.mainViewpager.adapter = sectionPagerAdapter
        binding.mainTab.setupWithViewPager(binding.mainViewpager)
        supportActionBar?.elevation = 0f

        binding.homeBottomNav.selectedItemId = R.id.home_nav
        binding.homeBottomNav.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId){
                R.id.home_nav -> return@OnNavigationItemSelectedListener true

                R.id.favorites_nav -> {
                    val intent = Intent(this@MainActivity, FavoriteActivity::class.java)
                    startActivity(intent)
                    return@OnNavigationItemSelectedListener true
                }
            }
            true
        })
    }
}