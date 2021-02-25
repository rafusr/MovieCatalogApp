package com.dicoding.andikas.moviecatalogapp.model.movie

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "movieentities")
data class Movie(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "movieId")
        val id: Int,

        @ColumnInfo(name = "backdropPath")
        val backdrop_path: String,

        @ColumnInfo(name = "genres")
        val genres: List<MovieGenre>?,

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
) : Parcelable
