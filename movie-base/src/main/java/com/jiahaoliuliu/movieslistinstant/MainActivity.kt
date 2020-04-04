package com.jiahaoliuliu.movieslistinstant

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), OnMovieClickListener {

    companion object {
        private const val MOVIE_DETAILS_DEEP_LINK = "https://movieslist.com/details"
        private const val MOVIE_DETAILS_DEEP_LINK_ID_KEY = "id"
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
        intent.data = createDeepLinkForMovieDetails(id)
        startActivity(intent)
    }

    private fun createDeepLinkForMovieDetails(id: Int): Uri {
        val uriString = "$MOVIE_DETAILS_DEEP_LINK?$MOVIE_DETAILS_DEEP_LINK_ID_KEY=$id"
        return Uri.parse(uriString)
    }
}