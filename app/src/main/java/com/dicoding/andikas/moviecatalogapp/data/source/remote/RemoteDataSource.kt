package com.dicoding.andikas.moviecatalogapp.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.andikas.moviecatalogapp.BuildConfig
import com.dicoding.andikas.moviecatalogapp.model.movie.ListMovie
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.dicoding.andikas.moviecatalogapp.model.tvshow.ListTvShow
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow
import com.dicoding.andikas.moviecatalogapp.network.RetroClient
import com.dicoding.andikas.moviecatalogapp.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource private constructor(private val retroClient: RetroClient) {

    companion object {
        private const val apiKey = BuildConfig.API_KEY

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(retroClient: RetroClient): RemoteDataSource =
                instance ?: synchronized(this) {
                    instance ?: RemoteDataSource(retroClient)
                }
    }

    fun getMovies(): LiveData<ApiResponse<List<Movie>>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<Movie>>>()
        retroClient.createService().getMovies(apiKey)
            .enqueue(object : Callback<ListMovie> {
                override fun onResponse(call: Call<ListMovie>, response: Response<ListMovie>) {
                    if (response.isSuccessful){
                        val responseBody = response.body()
                        if (responseBody != null){
                            val result = responseBody.results
                            resultMovie.value = ApiResponse.success(result)
                        }
                    }
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<ListMovie>, t: Throwable) {
                    Log.d("OnFailure", t.message.toString())
                }


            })
        return resultMovie
    }

    fun getMoviesDetails(movieId: String): LiveData<ApiResponse<Movie>> {
        EspressoIdlingResource.increment()
        val resultMovieDetail = MutableLiveData<ApiResponse<Movie>>()
        retroClient.createService().getMoviesDetails(movieId, apiKey)
            .enqueue(object : Callback<Movie>{
                override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                    if (response.isSuccessful){
                        val responseBody = response.body()
                        if (responseBody != null){
                            resultMovieDetail.value = ApiResponse.success(responseBody)
                        }
                    }
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<Movie>, t: Throwable) {
                    Log.d("OnFailure", t.message.toString())
                }

            })
        return resultMovieDetail
    }

    fun getTvShows(): LiveData<ApiResponse<List<TvShow>>> {
        EspressoIdlingResource.increment()
        val resultTvShow = MutableLiveData<ApiResponse<List<TvShow>>>()
        retroClient.createService().getTvShows(apiKey)
            .enqueue(object : Callback<ListTvShow>{
                override fun onResponse(call: Call<ListTvShow>, response: Response<ListTvShow>) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            val result = responseBody.results
                            resultTvShow.value = ApiResponse.success(result)
                        }
                    }
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<ListTvShow>, t: Throwable) {
                    Log.d("OnFailure", t.message.toString())
                }

            })
        return resultTvShow
    }

    fun getTvShowsDetails(tvShowId: String): LiveData<ApiResponse<TvShow>> {
        EspressoIdlingResource.increment()
        val resultTvShowDetail = MutableLiveData<ApiResponse<TvShow>>()
        retroClient.createService().getTvShowsDetails(tvShowId, apiKey)
            .enqueue(object : Callback<TvShow>{
                override fun onResponse(call: Call<TvShow>, response: Response<TvShow>) {
                    if (response.isSuccessful){
                        val responseBody = response.body()
                        if (responseBody != null){
                            resultTvShowDetail.value = ApiResponse.success(responseBody)
                        }
                    }
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<TvShow>, t: Throwable) {
                    Log.d("OnFailure", t.message.toString())
                }

            })
        return resultTvShowDetail
    }
}