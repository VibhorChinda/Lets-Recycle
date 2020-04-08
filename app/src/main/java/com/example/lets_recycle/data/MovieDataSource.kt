package com.example.lets_recycle.data

import androidx.lifecycle.LiveData
import com.example.lets_recycle.data.network.response.MovieResponse

interface MovieDataSource {

    val movies: LiveData<MovieResponse>

    suspend fun getMovies()
}