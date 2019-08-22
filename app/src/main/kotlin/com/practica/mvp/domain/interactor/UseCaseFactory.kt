package com.practica.mvp.domain.interactor

import com.practica.mvp.domain.Movie
import com.practica.mvp.domain.MoviesRepository
import com.practica.mvp.domain.executor.JobScheduler
import com.practica.mvp.domain.executor.UIScheduler
import javax.inject.Inject


class UseCaseFactory @Inject constructor(
        private val repository: MoviesRepository,
        private val uiScheduler: UIScheduler,
        private val jobScheduler: JobScheduler) {

    fun getMovie(): UseCase<Movie, GetMovie.Params> {
        return GetMovie(repository, uiScheduler, jobScheduler)
    }

    fun getMovies(): UseCase<List<Movie>, GetMovies.Params> {
        return GetMovies(repository, uiScheduler, jobScheduler)
    }

}