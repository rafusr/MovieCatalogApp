package com.dicoding.andikas.moviecatalogapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.andikas.moviecatalogapp.data.ContentRepository
import com.dicoding.andikas.moviecatalogapp.di.Injection

class ViewModelFactory(private val contentRepository: ContentRepository): ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory =
                instance ?: synchronized(this) {
                    instance ?: ViewModelFactory(Injection.movieRepository())
                }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> MovieViewModel(contentRepository) as T
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> TvShowViewModel(contentRepository) as T
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> DetailViewModel(contentRepository) as T
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }

}