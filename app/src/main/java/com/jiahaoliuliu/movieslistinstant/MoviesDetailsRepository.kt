package com.jiahaoliuliu.movieslistinstant

class MoviesDetailsRepository private constructor(){

    private object HOLDER {
        val INSTANCE = MoviesDetailsRepository()
    }

    companion object {
        val instance: MoviesDetailsRepository by lazy {HOLDER.INSTANCE}
    }

    private val moviesRepository = MoviesRepository.instance

    private val movieImagePairsMap: Map<Int, Pair<Int, String>> = MovieImagePairsEnum.toMap()

    fun getMovieDetailsById(movieId: Int): MovieDetails? {
        val movieNullable = moviesRepository.getMovieById(movieId)
        movieNullable?.let { movie ->
            val movieImagePairNullable = movieImagePairsMap[movieId]
            movieImagePairNullable?.let { movieImagePair ->
                return MovieDetails(movie.id, movie.title, movie.description, movie.thumbnailName, movieImagePair.second)
            }
        } ?: run {
            return null
        }
    }

    private enum class MovieImagePairsEnum(
        val id: Int,
        val imageName: String
    ) {
        BLOOD_SHOT(
            1,
            "movie_bloodshot"),
        BIRDS_OF_PRAY(
            2,
            "movie_birds_of_prey"),
        SONIC_THE_HEDGEHOG(
            3,
            "movie_sonic_the_hedgehog"),
        FROZEN_II(
            4,
            "movie_frozen_ii"),
        JUMANJI(
            5,
            "movie_jumanji_the_next_level")
        ;

        companion object {
            fun toMap(): Map<Int, Pair<Int, String>> {
                val movieImagePairsMap = HashMap<Int, Pair<Int, String>>()
                values().map {pair ->
                    movieImagePairsMap.put(pair.id, Pair(pair.id, pair.imageName)) }
                return movieImagePairsMap
            }
        }
    }
}