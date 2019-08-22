package com.practica.mvp.data.source.local

import com.practica.mvp.data.entity.MovieModel
import com.practica.mvp.data.entity.MovieModel_
import io.objectbox.kotlin.boxFor


class MoviesLocalDataSourceImpl : MoviesLocalDataSource {
    private val modelBox = ObjectBox.boxStore.boxFor(MovieModel::class)

    override fun getMovies(): List<MovieModel> {
        return modelBox.all
    }

    override fun getMovie(movieId: Int): MovieModel? {
        return modelBox.query().equal(MovieModel_.id, movieId.toLong()).build().find().firstOrNull()
    }

    override fun saveMovies(movieEntityList: List<MovieModel>) {
        modelBox.put(movieEntityList)
    }

    override fun deleteAllMovies() {
        modelBox.removeAll()
    }

}
