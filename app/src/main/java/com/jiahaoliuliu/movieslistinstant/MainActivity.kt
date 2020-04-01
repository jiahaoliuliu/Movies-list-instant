package com.jiahaoliuliu.movieslistinstant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), OnMovieClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.movies_list)
        val moviesRepository = MoviesRepository.instance
        val moviesListAdapter = MoviesListAdapter(moviesRepository.getMoviesList(), this)
        recyclerView.adapter = moviesListAdapter
    }

    override fun onMovieClicked(id: Int) {
        // Open movie details
        val intent = MovieDetailsActivity.getIntent(this, id)
        startActivity(intent)
    }
}