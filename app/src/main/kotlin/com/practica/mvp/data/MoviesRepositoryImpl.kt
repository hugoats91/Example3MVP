package com.practica.mvp.data


import com.practica.mvp.data.entity.MovieModel
import com.practica.mvp.data.entity.mapper.EntityDataMapper
import com.practica.mvp.data.source.local.MoviesLocalDataSource
import com.practica.mvp.data.source.remote.MoviesRemoteDataSource
import com.practica.mvp.domain.Movie
import com.practica.mvp.domain.MoviesRepository


class MoviesRepositoryImpl(
        private val localDataSource: MoviesLocalDataSource,
        private val remoteDataSource: MoviesRemoteDataSource,
        private val entityDataMapper: EntityDataMapper) : MoviesRepository {

    override fun getMovies(onlyOnline: Boolean): List<Movie> {
        var movieEntityList: List<MovieModel>
        if (onlyOnline) {
            movieEntityList = remoteDataSource.getMovies()
            saveData(movieEntityList)
        } else {
            movieEntityList = localDataSource.getMovies()
            if (movieEntityList.isEmpty()) {
                movieEntityList = remoteDataSource.getMovies()
                saveData(movieEntityList)
            }
        }
        return entityDataMapper.transform(movieEntityList)
    }

    private fun saveData(movieEntityList: List<MovieModel>) {
        localDataSource.deleteAllMovies()
        localDataSource.saveMovies(movieEntityList)
    }

    override fun getMovie(movieId: Int): Movie {
        return entityDataMapper.transform(localDataSource.getMovie(movieId))!!
    }

}