package com.dicoding.andikas.moviecatalogapp.data.source.remote

import android.os.Handler
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.andikas.moviecatalogapp.BuildConfig
import com.dicoding.andikas.moviecatalogapp.utils.EspressoIdlingResource
import com.dicoding.andikas.moviecatalogapp.model.movie.ListMovie
import com.dicoding.andikas.moviecatalogapp.model.movie.Movie
import com.dicoding.andikas.moviecatalogapp.model.tvshow.ListTvShow
import com.dicoding.andikas.moviecatalogapp.model.tvshow.TvShow
import com.dicoding.andikas.moviecatalogapp.network.RetroClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource private constructor(private val retroClient: RetroClient) {

    private val handler = Handler()

    companion object {
        private const val apiKey = BuildConfig.API_KEY
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(retroClient: RetroClient): RemoteDataSource =
                instance ?: synchronized(this) {
                    instance ?: RemoteDataSource(retroClient)
                }
    }

    /*
    fun getMovies(movieCallback: MovieCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            retroClient.createService().getMovies(apiKey)
                .enqueue(object : Callback<ListMovie> {
                    override fun onResponse(call: Call<ListMovie>, response: Response<ListMovie>) {
                        if (response.isSuccessful){
                            val responseBody = response.body()
                            if (responseBody != null){
                                val result = responseBody.results
                                movieCallback.onResponse(result)
                            }
                        }
                        EspressoIdlingResource.decrement()
                    }

                    override fun onFailure(call: Call<ListMovie>, t: Throwable) {
                        Log.d("OnFailure", t.message.toString())
                    }


                })
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getMoviesDetails(movieId: String, movieDetailCallback: MovieDetailCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            retroClient.createService().getMoviesDetails(movieId, apiKey)
                .enqueue(object : Callback<Movie>{
                    override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                        if (response.isSuccessful){
                            val responseBody = response.body()
                            if (responseBody != null){
                                movieDetailCallback.onResponse(responseBody)
                            }
                        }
                        EspressoIdlingResource.decrement()
                    }

                    override fun onFailure(call: Call<Movie>, t: Throwable) {
                        Log.d("OnFailure", t.message.toString())
                    }

                })
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getTvShows(tvShowCallback: TvShowCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            retroClient.createService().getTvShows(apiKey)
                .enqueue(object : Callback<ListTvShow>{
                    override fun onResponse(call: Call<ListTvShow>, response: Response<ListTvShow>) {
                        if (response.isSuccessful) {
                            val responseBody = response.body()
                            if (responseBody != null) {
                                val result = responseBody.results
                                tvShowCallback.onResponse(result)
                            }
                        }
                        EspressoIdlingResource.decrement()
                    }

                    override fun onFailure(call: Call<ListTvShow>, t: Throwable) {
                        Log.d("OnFailure", t.message.toString())
                    }

                })
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getTvShowsDetails(movieId: String, tvShowDetailCallback: TvShowDetailCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            retroClient.createService().getTvShowsDetails(movieId, apiKey)
                .enqueue(object : Callback<TvShow>{
                    override fun onResponse(call: Call<TvShow>, response: Response<TvShow>) {
                        if (response.isSuccessful){
                            val responseBody = response.body()
                            if (responseBody != null){
                                tvShowDetailCallback.onResponse(responseBody)
                            }
                        }
                        EspressoIdlingResource.decrement()
                    }

                    override fun onFailure(call: Call<TvShow>, t: Throwable) {
                        Log.d("OnFailure", t.message.toString())
                    }

                })
        }, SERVICE_LATENCY_IN_MILLIS)
    }
    */

    fun getMovies(): LiveData<ApiResponse<List<Movie>>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<Movie>>>()
        handler.postDelayed({
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
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultMovie
    }

    fun getMoviesDetails(movieId: String): LiveData<ApiResponse<Movie>> {
        EspressoIdlingResource.increment()
        val resultMovieDetail = MutableLiveData<ApiResponse<Movie>>()
        handler.postDelayed({
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
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultMovieDetail
    }

    fun getTvShows(): LiveData<ApiResponse<List<TvShow>>> {
        EspressoIdlingResource.increment()
        val resultTvShow = MutableLiveData<ApiResponse<List<TvShow>>>()
        handler.postDelayed({
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
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultTvShow
    }

    fun getTvShowsDetails(tvShowId: String): LiveData<ApiResponse<TvShow>> {
        EspressoIdlingResource.increment()
        val resultTvShowDetail = MutableLiveData<ApiResponse<TvShow>>()
        handler.postDelayed({
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
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultTvShowDetail
    }

    interface MovieCallback {
        fun onResponse(movieResponse: List<Movie>)
    }

    interface MovieDetailCallback {
        fun onResponse(movieDetailResponse: Movie)
    }

    interface TvShowCallback {
        fun onResponse(tvShowResponse: List<TvShow>)
    }

    interface TvShowDetailCallback {
        fun onResponse(tvShowDetail: TvShow)
    }

}