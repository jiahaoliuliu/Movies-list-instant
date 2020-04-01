package com.jiahaoliuliu.movieslistinstant

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.jiahaoliuliu.movieslistinstant.databinding.ActivityMovieDetailsBinding
import java.lang.IllegalArgumentException

class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailsBinding
    private val moviesRepository = MoviesRepository.instance
    private var movieId = DEFAULT_MOVIE_ID

    companion object {
        private const val INTENT_EXTRA_MOVIE_ID = "Movie id"
        private const val DEFAULT_MOVIE_ID = -1

        fun getIntent(context: Context, movieId: Int): Intent {
            val intent = Intent(context, MovieDetailsActivity::class.java)
            intent.putExtra(INTENT_EXTRA_MOVIE_ID, movieId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieId = intent.getIntExtra(INTENT_EXTRA_MOVIE_ID, DEFAULT_MOVIE_ID)
        if (movieId == DEFAULT_MOVIE_ID) {
            throw IllegalArgumentException("You must pass the movie id on the intent")
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details)
        val movie = moviesRepository.getMovieById(movieId)
        movie?.let {
            binding.movie = movie
        } ?: run{
            throw IllegalArgumentException("Movie not found")
        }
    }
}
