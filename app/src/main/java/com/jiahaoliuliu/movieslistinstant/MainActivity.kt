package com.jiahaoliuliu.movieslistinstant

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), OnMovieClickListener {

    companion object {
        private const val URL_ABS_GENERAL = "https://movieslist.com"
        private const val URL_REL_DETAILS = "/details"
    }

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
        val intent = Intent(Intent.ACTION_VIEW)
        val uri = Uri.parse("$URL_ABS_GENERAL$URL_REL_DETAILS?id=$id")
        intent.data = uri
        startActivity(intent)
    }
}