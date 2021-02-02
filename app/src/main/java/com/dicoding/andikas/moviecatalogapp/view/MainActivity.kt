package com.dicoding.andikas.moviecatalogapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.andikas.moviecatalogapp.adapter.SectionPagerAdapter
import com.dicoding.andikas.moviecatalogapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Movie Catalogue"

        binding.mainViewpager.adapter = SectionPagerAdapter(this, supportFragmentManager)
        binding.mainTab.setupWithViewPager(binding.mainViewpager)
        supportActionBar?.elevation = 0f
    }
}