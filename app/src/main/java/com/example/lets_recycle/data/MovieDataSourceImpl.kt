package com.example.lets_recycle.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.lets_recycle.data.network.service.MovieApiService
import com.example.lets_recycle.data.network.response.MovieResponse

class MovieDataSourceImpl(private val movieApiService: MovieApiService) : MovieDataSource {

    private val _movies = MutableLiveData<MovieResponse>()

    override val movies: LiveData<MovieResponse>
        get() = _movies

    override suspend fun getMovies() {
        val movies = movieApiService.getMovies()
        _movies.postValue(movies.body())
    }
}