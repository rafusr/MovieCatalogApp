package com.dicoding.andikas.moviecatalogapp.model.movie

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
        val id: Int,
        val backdrop_path: String,
        val genres: List<MovieGenre>,
        val original_title: String,
        val overview: String,
        val poster_path: String,
        val release_date: String
) : Parcelable
