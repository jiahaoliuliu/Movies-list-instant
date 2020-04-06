package com.jiahaoliuliu.movieslistinstant.moviedetails

import com.jiahaoliuliu.datalayer.IMovie

data class MovieDetails(
    override val id: Int,
    override val title: String,
    override val description: String,
    override val thumbnailName: String,
    val imageId: Int): com.jiahaoliuliu.datalayer.IMovie()