package com.practica.mvp.platform.di.detail


import com.practica.mvp.domain.interactor.UseCaseFactory
import com.practica.mvp.platform.views.DetailMovieActivity
import com.practica.mvp.presentation.formatters.Formatter
import com.practica.mvp.presentation.presenters.DetailMoviePresenter
import dagger.Module
import dagger.Provides


@Module
class DetailActivityModule {

    @Provides
    internal fun providePresenter(activity: DetailMovieActivity, useCaseFactory: UseCaseFactory,
                                  formatter: Formatter): DetailMoviePresenter {
        val movieId = activity.intent.getIntExtra(DetailMovieActivity.EXTRA_MOVIE_ID, -1)
        val presenter = DetailMoviePresenter(useCaseFactory, formatter, movieId)
        presenter.setView(activity)
        return presenter
    }

}
