package com.dicoding.andikas.moviecatalogapp.data.source.local.room

import android.content.Context
import androidx.room.*
import com.dicoding.andikas.moviecatalogapp.utils.Converter
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow

@Database(entities = [Movie::class, TvShow::class],
    version = 1,
    exportSchema = false
    )
@TypeConverters(Converter::class)
abstract class ContentDatabase: RoomDatabase() {

    abstract fun contentDao(): ContentDao

    companion object {
        @Volatile
        private var INSTANCE: ContentDatabase? = null

        fun getInstance(context: Context): ContentDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(context.applicationContext,
                    ContentDatabase::class.java,
                    "Content.db").build()
            }
    }

}