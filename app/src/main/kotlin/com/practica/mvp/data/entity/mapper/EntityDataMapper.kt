package com.practica.mvp.data.entity.mapper

import com.practica.mvp.domain.Movie
import com.practica.mvp.data.entity.MovieEntity
import com.practica.mvp.data.entity.MovieModel
import javax.inject.Inject

class EntityDataMapper @Inject constructor() {

    fun transform(movieModel: MovieModel?): Movie? {
        var movie: Movie? = null
        if (movieModel != null) {
            movie = Movie(movieModel.id.toInt(),
                    movieModel.voteAverage,
                    movieModel.title,
                    movieModel.posterPath,
                    movieModel.backdropPath,
                    movieModel.overview,
                    movieModel.releaseDate)
        }
        return movie
    }

    fun transform(movieEntityList: List<MovieModel>): List<Movie> {
        val movieList = mutableListOf<Movie>()
        for (movieEntity in movieEntityList) {
            val movie = transform(movieEntity)
            if (movie != null) {
                movieList.add(movie)
            }
        }
        return movieList
    }
    
}