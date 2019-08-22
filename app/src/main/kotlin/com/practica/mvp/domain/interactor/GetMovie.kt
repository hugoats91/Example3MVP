package com.practica.mvp.domain.interactor

import com.practica.mvp.domain.Movie
import com.practica.mvp.domain.MoviesRepository
import com.practica.mvp.domain.executor.JobScheduler
import com.practica.mvp.domain.executor.UIScheduler
import io.reactivex.Single


class GetMovie(
        private val repository: MoviesRepository,
        uiScheduler: UIScheduler,
        jobScheduler: JobScheduler): UseCase<Movie, GetMovie.Params>(uiScheduler, jobScheduler) {

    override fun buildUseCaseObservable(params: Params): Single<Movie> {
        return Single.just(repository.getMovie(params.movieId))
    }

    class Params(val movieId: Int)
}

