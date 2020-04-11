package com.example.lets_recycle.ui.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lets_recycle.MainActivity
import com.example.lets_recycle.R
import com.example.lets_recycle.data.network.response.MovieResponseItem
import kotlinx.android.synthetic.main.movie_list_item_recycler_view.view.*

class MoviesAdapter(private val context: MainActivity, private val moviesList: ArrayList<MovieResponseItem>):
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.movie_list_item_recycler_view, parent, false))
    }

    override fun getItemCount(): Int {
       return moviesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = moviesList[position]
        holder.heroName.text = movie.name

        GlideApp.with(context)
            .load(movie.imageurl)
            .placeholder(R.drawable.captainamerica)
            .into(holder.heroImage)
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val heroName = view.hero_name
        val heroImage = view.hero_image
    }
}
