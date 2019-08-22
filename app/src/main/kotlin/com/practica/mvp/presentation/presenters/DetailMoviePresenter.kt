package com.practica.mvp.presentation.presenters


import com.practica.mvp.domain.Movie
import com.practica.mvp.domain.Observer
import com.practica.mvp.domain.interactor.GetMovie
import com.practica.mvp.domain.interactor.UseCaseFactory
import com.practica.mvp.presentation.DetailMovieView
import com.practica.mvp.presentation.formatters.Formatter
import java.lang.ref.WeakReference


class DetailMoviePresenter(private val useCaseFactory: UseCaseFactory,
                           private val formatter: Formatter,
                           private val movieId: Int): BasePresenter() {

    private lateinit var view: WeakReference<DetailMovieView>
    

    fun setView(detailMovieView: DetailMovieView) {
        view = WeakReference(detailMovieView)
    }

    fun viewReady() {
        val useCase = useCaseFactory.getMovie()
        addDisposable(useCase.execute(MovieObserver(), GetMovie.Params(movieId)))
    }

    private inner class MovieObserver : Observer<Movie>() {
        override fun onSuccess(t: Movie) {
            view.get()?.let {
                it.displayImage(formatter.getCompleteUrlImage(t.backdropPath))
                it.displayTitle(t.title)
                it.displayVoteAverage(t.voteAverage)
                it.displayReleaseDate(formatter.formatDate(t.releaseDate))
                it.displayOverview(t.overview)
            }
        }
    }

    fun navUpSelected() {
        view.get()?.goToBack()
    }

}