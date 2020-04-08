package com.example.lets_recycle.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.lets_recycle.data.MovieDataSource
import com.example.lets_recycle.data.network.response.MovieResponse

class MovieRepositoryImpl(private val movieDataSource: MovieDataSource) : MovieRepository {

    private val _movies = MutableLiveData<MovieResponse>()

    init {
        movieDataSource.movies.observeForever {
            _movies.postValue(it)
        }
    }

    override val movies: LiveData<MovieResponse>
        get() = _movies

    override suspend fun getMovies() {
        movieDataSource.getMovies()
    }
}