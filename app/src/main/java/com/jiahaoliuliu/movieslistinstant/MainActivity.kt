package com.jiahaoliuliu.movieslistinstant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.movies_list)
        val moviesRepository = MoviesRepository()
        val moviesListAdapter = MoviesListAdapter(moviesRepository.getMoviesList())
        recyclerView.adapter = moviesListAdapter
    }
}