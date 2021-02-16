package com.dicoding.andikas.moviecatalogapp.di

import com.dicoding.andikas.moviecatalogapp.network.RetroClient
import com.dicoding.andikas.moviecatalogapp.remote.RemoteDataSource
import com.dicoding.andikas.moviecatalogapp.data.ContentRepository

object Injection {

    fun movieRepository(): ContentRepository {
        val remoteRepository = RemoteDataSource.getInstance(RetroClient)
        return ContentRepository.getInstance(remoteRepository)
    }

}