package com.example.lets_recycle.data.network

import com.example.lets_recycle.data.network.response.MovieResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MovieApiService {

    @GET("marvel")
    suspend fun getMovies(): Response<MovieResponse>

    companion object {
        operator fun invoke() : MovieApiService {
            return Retrofit.Builder()
                .baseUrl("https://simplifiedcoding.net/demos/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MovieApiService :: class.java)
        }
    }
}