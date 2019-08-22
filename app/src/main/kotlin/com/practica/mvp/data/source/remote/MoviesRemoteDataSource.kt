package com.practica.mvp.data.source.remote

import com.practica.mvp.data.entity.MovieModel


interface MoviesRemoteDataSource {

    @Throws(Exception::class)
    fun getMovies(): List<MovieModel>

}