package com.example.lets_recycle.data.repository

import androidx.lifecycle.LiveData
import com.example.lets_recycle.data.network.response.MovieResponse

interface MovieRepository {

    val movies: LiveData<MovieResponse>

    suspend fun getMovies()
}