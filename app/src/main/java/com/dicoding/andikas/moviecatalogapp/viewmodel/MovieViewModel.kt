package com.dicoding.andikas.moviecatalogapp.viewmodel

import androidx.lifecycle.ViewModel
import com.dicoding.andikas.moviecatalogapp.utils.DataDummy

class MovieViewModel : ViewModel() {

    fun getMovies() = DataDummy.generateDummyMovies()

}