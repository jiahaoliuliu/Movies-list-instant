package com.jiahaoliuliu.movieslistinstant.moviedetails

import com.jiahaoliuliu.movieslistinstant.IMovie

data class MovieDetails(
    override val id: Int,
    override val title: String,
    override val description: String,
    override val thumbnailName: String,
    val imageId: Int): IMovie()