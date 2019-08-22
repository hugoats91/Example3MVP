package com.practica.mvp.domain.interactor

import com.practica.mvp.domain.Movie
import com.practica.mvp.domain.MoviesRepository
import com.practica.mvp.domain.executor.JobScheduler
import com.practica.mvp.domain.executor.UIScheduler
import io.reactivex.Single


class GetMovies(
        private val repository: MoviesRepository,
        uiScheduler: UIScheduler,
        jobScheduler: JobScheduler): UseCase<List<Movie>, GetMovies.Params>(uiScheduler, jobScheduler) {

    override fun buildUseCaseObservable(params: Params): Single<List<Movie>> {
        return Single.create { emitter ->
            try {
                val movieList = repository.getMovies(params.isOnlyOnline)
                emitter.onSuccess(movieList)
            } catch (exception: Exception) {
                if (!emitter.isDisposed) {
                    emitter.onError(exception)
                }
            }
        }
    }

    class Params(val isOnlyOnline: Boolean)
}

