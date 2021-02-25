package com.dicoding.andikas.moviecatalogapp.di

import android.content.Context
import com.dicoding.andikas.moviecatalogapp.network.RetroClient
import com.dicoding.andikas.moviecatalogapp.data.source.remote.RemoteDataSource
import com.dicoding.andikas.moviecatalogapp.data.source.ContentRepository
import com.dicoding.andikas.moviecatalogapp.data.source.local.LocalDataSource
import com.dicoding.andikas.moviecatalogapp.data.source.local.room.ContentDatabase
import com.dicoding.andikas.moviecatalogapp.utils.AppExecutors

object Injection {

    fun movieRepository(context: Context): ContentRepository {

        val database = ContentDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(RetroClient)
        val localDataSource = LocalDataSource.getInstance(database.contentDao())
        val appExecutors = AppExecutors()

        return ContentRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

}