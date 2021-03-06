package com.jiahaoliuliu.datalayer

class MoviesRepository private constructor(){

    private object HOLDER {
        val INSTANCE = MoviesRepository()
    }

    companion object {
        val instance: MoviesRepository by lazy { HOLDER.INSTANCE }
    }

    private val moviesMap: Map<Int, Movie> =
        MoviesListEnum.toMoviesList()
    private val moviesList = ArrayList(moviesMap.values)

    fun getMoviesList(): List<Movie> {
        return moviesList
    }

    fun getMovieById(movieId: Int): Movie? {
        return moviesMap[movieId]
    }

    private enum class MoviesListEnum(
        val id: Int,
        val title: String,
        val description: String,
        val thumbnailName: String,
        val imageUrl: String
    ) {
        BLOOD_SHOT(
            1,
            "BloodShot",
            "After he and his wife are murdered, marine Ray Garrison is resurrected by a team of scientists. Enhanced with nanotechnology, he becomes a superhuman, biotech killing machine—'Bloodshot'. As Ray first trains with fellow super-soldiers, he cannot recall anything from his former life. But when his memories flood back and he remembers the man that killed both him and his wife, he breaks out of the facility to get revenge, only to discover that there's more to the conspiracy than he thought.",
            "movie_bloodshot_thumb",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/8WUVHemHFH2ZIP6NWkwlHWsyrEL.jpg"),
        BIRDS_OF_PRAY(
            2,
            "Birds of Prey",
            "After her breakup with the Joker, Harley Quinn joins forces with singer Black Canary, assassin Huntress, and police detective Renee Montoya to help a young girl named Cassandra, who had a hit placed on her after she stole a rare diamond from crime lord Roman Sionis",
            "movie_birds_of_prey_thumb",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/h4VB6m0RwcicVEZvzftYZyKXs6K.jpg"),
        SONIC_THE_HEDGEHOG(
            3,
            "Sonic the Hedgehog",
            "Based on the global blockbuster videogame franchise from Sega, Sonic the Hedgehog tells the story of the world’s speediest hedgehog as he embraces his new home on Earth. In this live-action adventure comedy, Sonic and his new best friend team up to defend the planet from the evil genius Dr. Robotnik and his plans for world domination.",
            "movie_sonic_the_hedgehog_thumb",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/aQvJ5WPzZgYVDrxLX4R6cLJCEaQ.jpg"),
        FROZEN_II(
            4,
            "FROZEN II",
            "Elsa, Anna, Kristoff and Olaf head far into the forest to learn the truth about an ancient mystery of their kingdom.",
            "movie_frozen_ii_thumb",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/pjeMs3yqRmFL3giJy4PMXWZTTPa.jpg"),
        JUMANJI(
            5,
            "Jumanji: The Next Level",
            "As the gang return to Jumanji to rescue one of their own, they discover that nothing is as they expect. The players will have to brave parts unknown and unexplored in order to escape the world’s most dangerous game.",
            "movie_jumanji_the_next_level_thumb",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/bB42KDdfWkOvmzmYkmK58ZlCa9P.jpg")
        ;

        companion object {
            fun toMoviesList(): Map<Int, Movie> {
                val moviesList = HashMap<Int, Movie>()
                values().map {movie ->
                    moviesList.put(movie.id, Movie(movie.id, movie.title, movie.description, movie.thumbnailName, movie.imageUrl)) }
                return moviesList
            }
        }
    }
}