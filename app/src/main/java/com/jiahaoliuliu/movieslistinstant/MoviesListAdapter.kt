package com.jiahaoliuliu.movieslistinstant

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jiahaoliuliu.movieslistinstant.databinding.ItemMovieBinding

class MoviesListAdapter(private val moviesList: List<Movie>): RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = moviesList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(moviesList[position])
    }
}

class MovieViewHolder(private val movieItemBinding: ItemMovieBinding) : RecyclerView.ViewHolder(movieItemBinding.root) {

    fun bind(movie: Movie) {
        movieItemBinding.movie = movie
        movieItemBinding.executePendingBindings()
    }
}