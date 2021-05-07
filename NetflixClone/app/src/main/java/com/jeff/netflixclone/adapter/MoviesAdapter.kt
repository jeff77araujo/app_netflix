package com.jeff.netflixclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jeff.netflixclone.databinding.ActivityListMoviesBinding
import com.jeff.netflixclone.databinding.ListMoviesBinding
import com.jeff.netflixclone.model.Movies

class MoviesAdapter(val movies: MutableList<Movies>): RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding = ListMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(binding)
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        with(holder) {
            with(movies[position]) {
                binding.coverMovie.setImageResource(movieCover)
            }
        }
    }

    inner class MoviesViewHolder(val binding: ListMoviesBinding): RecyclerView.ViewHolder(binding.root) {

    }
}