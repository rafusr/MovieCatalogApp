package com.dicoding.andikas.moviecatalogapp.utils

import androidx.room.TypeConverter
import com.dicoding.andikas.moviecatalogapp.model.movie.MovieGenre
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShowGenre
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {

    @TypeConverter
    fun mListToJson(value: List<MovieGenre>?): String? {
        val gson = Gson()
        val type = object : TypeToken<List<MovieGenre?>?>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun mJsonToList(value: String?): List<MovieGenre>? {
        val gson = Gson()
        val type = object : TypeToken<List<MovieGenre?>?>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun tListToJson(value: List<TvShowGenre>?): String? {
        val gson = Gson()
        val type = object : TypeToken<List<TvShowGenre?>?>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun tJsonToList(value: String?): List<TvShowGenre>? {
        val gson = Gson()
        val type = object : TypeToken<List<TvShowGenre?>?>() {}.type
        return gson.fromJson(value, type)
    }

}