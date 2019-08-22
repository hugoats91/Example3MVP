package com.practica.mvp.data.source.remote


import com.practica.mvp.data.entity.MovieEntity
import com.practica.mvp.data.entity.MovieModel
import com.practica.mvp.data.exception.NetworkConnectionException
import com.practica.mvp.data.exception.ServiceException
import java.io.IOException

private const val API_KEY = "a05acc76ea7742780a70e416f0197689"

class MoviesRemoteDataSourceImpl(private val movieService: MovieService) : MoviesRemoteDataSource {

    override fun getMovies(): List<MovieModel> {
        try {
            val response = movieService.getMovies(API_KEY).execute()
            if (response.isSuccessful) {
                return response.body().movies.map { it.toMovieModel() }
            } else {
                throw ServiceException()
            }
        } catch (exception: IOException) {
            throw NetworkConnectionException()
        }
    }

}