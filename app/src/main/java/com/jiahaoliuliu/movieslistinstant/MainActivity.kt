package com.jiahaoliuliu.movieslistinstant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), OnMovieClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.movies_list)
        val moviesRepository = MoviesRepository()
        val moviesListAdapter = MoviesListAdapter(moviesRepository.getMoviesList(), this)
        recyclerView.adapter = moviesListAdapter
    }

    override fun onMovieClicked(id: Int) {
        // Open movie details
        Toast.makeText(this, "Click on the item $id", Toast.LENGTH_LONG).show()
    }
}