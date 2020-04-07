package com.jiahaoliuliu.movieslistinstant

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jiahaoliuliu.datalayer.Movie
import com.jiahaoliuliu.movieslistinstant.databinding.ItemMovieBinding

class MoviesListAdapter(private val moviesList: List<Movie>, private val onMovieClickListener: OnMovieClickListener): RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = moviesList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = moviesList[position]
        holder.itemView.setOnClickListener{ onMovieClickListener.onMovieClicked(movie.id)}
        holder.bind(movie)
    }
}

class MovieViewHolder(private val movieItemBinding: ItemMovieBinding) : RecyclerView.ViewHolder(movieItemBinding.root) {

    fun bind(movie: Movie) {
        movieItemBinding.movie = movie
        movieItemBinding.executePendingBindings()
    }
}

interface OnMovieClickListener {

    fun onMovieClicked(id: Int)
}