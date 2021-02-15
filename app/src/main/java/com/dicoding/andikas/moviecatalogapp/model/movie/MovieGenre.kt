package com.dicoding.andikas.moviecatalogapp.model.movie

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieGenre(
    val name: String
) : Parcelable