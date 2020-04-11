package com.example.lets_recycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.lets_recycle.data.MovieDataSourceImpl
import com.example.lets_recycle.data.network.service.MovieApiService
import com.example.lets_recycle.data.repository.MovieRepositoryImpl
import com.example.lets_recycle.ui.movies.MoviesAdapter
import com.example.lets_recycle.ui.movies.MoviesViewModel
import com.example.lets_recycle.ui.movies.MoviesViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movieApiService = MovieApiService()
        val movieDataSourceImpl = MovieDataSourceImpl(movieApiService)
        val movieRepositoryImpl = MovieRepositoryImpl(movieDataSourceImpl)
        val moviesViewModelFactory = MoviesViewModelFactory(movieRepositoryImpl)
        val viewModel = ViewModelProvider(this@MainActivity, moviesViewModelFactory).get(MoviesViewModel::class.java)

        viewModel.movies.observe(this@MainActivity, Observer {
            val adapter = MoviesAdapter(this@MainActivity, it)
            recycler_view_movies.adapter = adapter
        })

        GlobalScope.launch (Dispatchers.Main) {
            viewModel.getMovies()
        }
    }
}
