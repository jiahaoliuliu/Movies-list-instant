package com.jiahaoliuliu.movieslistinstant

data class MovieDetails(
    override val id: Int,
    override val title: String,
    override val description: String,
    override val thumbnailName: String,
    val imageName: String): IMovie()