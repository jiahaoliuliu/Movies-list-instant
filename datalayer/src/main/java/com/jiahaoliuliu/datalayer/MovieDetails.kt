package com.jiahaoliuliu.datalayer

data class MovieDetails(
    override val id: Int,
    override val title: String,
    override val description: String,
    override val thumbnailName: String,
    val imageUrl: String): IMovie()