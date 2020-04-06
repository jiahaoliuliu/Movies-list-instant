package com.jiahaoliuliu.movieslistinstant

data class Movie(
    override val id: Int,
    override val title: String,
    override val description: String,
    override val thumbnailName: String): IMovie()