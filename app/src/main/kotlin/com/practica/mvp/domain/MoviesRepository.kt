package com.practica.mvp.domain


interface MoviesRepository {

    @Throws(Exception::class)
    fun getMovies(onlyOnline: Boolean): List<Movie>

    fun getMovie(movieId: Int): Movie

}