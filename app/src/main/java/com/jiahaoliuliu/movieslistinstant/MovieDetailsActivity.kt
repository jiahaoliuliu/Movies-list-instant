package com.jiahaoliuliu.movieslistinstant

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.jiahaoliuliu.movieslistinstant.databinding.ActivityMovieDetailsBinding
import java.lang.IllegalArgumentException

class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailsBinding
    private val moviesDetailsRepository = MoviesDetailsRepository.instance
    private var movieId = DEFAULT_MOVIE_ID

    companion object {
        private const val INTENT_EXTRA_MOVIE_ID = "id"
        private const val DEFAULT_MOVIE_ID = -1

        fun getIntent(context: Context, movieId: Int): Intent {
            val intent = Intent(context, MovieDetailsActivity::class.java)
            intent.putExtra(INTENT_EXTRA_MOVIE_ID, movieId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieId = getMovieId()
        if (movieId == DEFAULT_MOVIE_ID) {
            throw IllegalArgumentException("You must pass the movie id on the intent")
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details)
        val movie = moviesDetailsRepository.getMovieDetailsById(movieId)
        movie?.let {
            binding.movieDetails = it
            setupToolbar(it.title)
        } ?: run{
            throw IllegalArgumentException("Movie not found")
        }
    }

    private fun setupToolbar(title: String) {
        setSupportActionBar(binding.toolbar)
        binding.toolbar.title = title
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getMovieId(): Int {
        if (intent.action == Intent.ACTION_VIEW) {
            intent.data?.let {uri ->
                uri.getQueryParameter(INTENT_EXTRA_MOVIE_ID)?.toInt()?.let {
                    return it
                }
            }
        } else {
            return intent.getIntExtra(INTENT_EXTRA_MOVIE_ID, DEFAULT_MOVIE_ID)
        }
        return DEFAULT_MOVIE_ID
    }
}
