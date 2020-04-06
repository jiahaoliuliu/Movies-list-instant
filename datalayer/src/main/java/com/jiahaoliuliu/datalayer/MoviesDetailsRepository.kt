package com.jiahaoliuliu.datalayer

class MoviesDetailsRepository private constructor(){

    private object HOLDER {
        val INSTANCE =
            MoviesDetailsRepository()
    }

    companion object {
        val instance: MoviesDetailsRepository by lazy { HOLDER.INSTANCE }
    }

    private val moviesRepository =
        MoviesRepository.instance

    private val movieImagePairsMap: Map<Int, Pair<Int, String>> =
        MovieImagePairsEnum.toMap()

    fun getMovieDetailsById(movieId: Int): MovieDetails? {
        val movieNullable = moviesRepository.getMovieById(movieId)
        movieNullable?.let { movie ->
            val movieImagePairNullable = movieImagePairsMap[movieId]
            movieImagePairNullable?.let { movieImagePair ->
                return MovieDetails(
                    movie.id,
                    movie.title,
                    movie.description,
                    movie.thumbnailName,
                    movieImagePair.second
                )
            }
        } ?: run {
            return null
        }
    }

    private enum class MovieImagePairsEnum(
        val id: Int,
        val imageUrl: String
    ) {
        BLOOD_SHOT(
            1,
            "https://raw.githubusercontent.com/jiahaoliuliu/Movies-list-instant/master/app/src/main/res/drawable/movie_bloodshot.jpg"
        ),
        BIRDS_OF_PRAY(
            2,
            "https://raw.githubusercontent.com/jiahaoliuliu/Movies-list-instant/master/app/src/main/res/drawable/movie_birds_of_prey.jpg"
        ),
        SONIC_THE_HEDGEHOG(
            3,
            "https://raw.githubusercontent.com/jiahaoliuliu/Movies-list-instant/master/app/src/main/res/drawable/movie_sonic_the_hedgehog.jpg"
        ),
        FROZEN_II(
            4,
            "https://raw.githubusercontent.com/jiahaoliuliu/Movies-list-instant/master/app/src/main/res/drawable/movie_frozen_ii.jpg"
        ),
        JUMANJI(
            5,
            "https://raw.githubusercontent.com/jiahaoliuliu/Movies-list-instant/master/app/src/main/res/drawable/movie_jumanji_the_next_level.jpg"
        )
        ;

        companion object {
            fun toMap(): Map<Int, Pair<Int, String>> {
                val movieImagePairsMap = HashMap<Int, Pair<Int, String>>()
                values().map {pair ->
                    movieImagePairsMap.put(pair.id, Pair(pair.id, pair.imageUrl)) }
                return movieImagePairsMap
            }
        }
    }
}