package com.dicoding.andikas.moviecatalogapp.di

import com.dicoding.andikas.moviecatalogapp.network.RetroClient
import com.dicoding.andikas.moviecatalogapp.remote.RemoteDataSource
import com.dicoding.andikas.moviecatalogapp.data.MovieRepository

object Injection {

    fun movieRepository(): MovieRepository {
        val remoteRepository = RemoteDataSource.getInstance(RetroClient)
        return MovieRepository.getInstance(remoteRepository)
    }

}