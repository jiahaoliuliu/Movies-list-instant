package com.jiahaoliuliu.movieslistinstant

class MoviesRepository {

    private val moviesMap: Map<Int, Movie> = MoviesListEnum.toMoviesList()
    private val moviesList = ArrayList(moviesMap.values)

    fun getMoviesList(): List<Movie> {
        return moviesList
    }

    private enum class MoviesListEnum(
        val id: Int,
        val title: String,
        val description: String,
        val imageId: Int
    ) {
        // TODO: Add more movies
        BLOOD_SHOT(
            1,
            "BloodShot",
            "After he and his wife are murdered, marine Ray Garrison is resurrected by a team of scientists. Enhanced with nanotechnology, he becomes a superhuman, biotech killing machine—'Bloodshot'. As Ray first trains with fellow super-soldiers, he cannot recall anything from his former life. But when his memories flood back and he remembers the man that killed both him and his wife, he breaks out of the facility to get revenge, only to discover that there's more to the conspiracy than he thought.",
            R.drawable.movie_bloodshot);

        companion object {
            fun toMoviesList(): Map<Int, Movie> {
                val moviesList = HashMap<Int, Movie>()
                values().map {movie ->
                    moviesList.put(movie.id, Movie(movie.id, movie.title, movie.description, movie.imageId)) }
                return moviesList
            }
        }
    }
}