package com.example.lets_recycle.ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lets_recycle.data.repository.MovieRepository

class MoviesViewModelFactory(private val movieRepository: MovieRepository): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoviesViewModel(movieRepository) as T
    }
}