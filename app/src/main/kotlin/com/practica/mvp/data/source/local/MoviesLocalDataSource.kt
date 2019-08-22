package com.practica.mvp.data.source.local

import com.practica.mvp.data.entity.MovieModel


interface MoviesLocalDataSource {

    fun getMovies(): List<MovieModel>

    fun getMovie(movieId: Int): MovieModel?

    fun saveMovies(movieEntityList: List<MovieModel>)

    fun deleteAllMovies()

}