package com.jiahaoliuliu.movieslistinstant.details

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.jiahaoliuliu.movieslistinstant.MoviesRepository
import java.lang.IllegalArgumentException

class MovieDetailsActivity : AppCompatActivity() {

    // Views
    private lateinit var toolbar: Toolbar
    private lateinit var coverImage: ImageView
    private lateinit var description: TextView

    private val moviesRepository = MoviesRepository.instance
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
        val movie = moviesRepository.getMovieById(movieId)
        movie?.let {
            findViews()
            setupToolbar(movie.title)
            coverImage.setImageResource(movie.imageId)
            description.text = movie.description
        } ?: run{
            throw IllegalArgumentException("Movie not found")
        }
    }

    private fun findViews() {
        toolbar = findViewById(R.id.toolbar)
        coverImage = findViewById(R.id.cover)
        description = findViewById(R.id.description)
    }

    private fun setupToolbar(title: String) {
        setSupportActionBar(toolbar)
        toolbar.title = title
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
