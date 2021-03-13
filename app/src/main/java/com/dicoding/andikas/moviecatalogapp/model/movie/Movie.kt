package com.dicoding.andikas.moviecatalogapp.model.movie

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movieentities")
data class Movie(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "movieId")
        val id: Int,

        @ColumnInfo(name = "backdropPath")
        val backdrop_path: String,

        @ColumnInfo(name = "title")
        val original_title: String,

        @ColumnInfo(name = "overview")
        val overview: String,

        @ColumnInfo(name = "posterPath")
        val poster_path: String,

        @ColumnInfo(name = "releaseDate")
        val release_date: String,

        @ColumnInfo(name = "favorited")
        var favorited: Boolean
)
