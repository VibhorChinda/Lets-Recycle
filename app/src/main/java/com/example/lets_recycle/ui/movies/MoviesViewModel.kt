package com.example.lets_recycle.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lets_recycle.data.network.response.MovieResponse
import com.example.lets_recycle.data.repository.MovieRepository

class MoviesViewModel(private val movieRepository: MovieRepository): ViewModel() {

    private val _movies = MutableLiveData<MovieResponse>()

    init {
        movieRepository.movies.observeForever {
            _movies.postValue(it)
        }
    }

    val movies : LiveData<MovieResponse>
    get() = _movies

    suspend fun getMovies() {
       val movies =  movieRepository.getMovies()
    }
}
