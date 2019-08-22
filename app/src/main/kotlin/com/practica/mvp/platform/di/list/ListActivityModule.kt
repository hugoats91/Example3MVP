package com.practica.mvp.platform.di.list

import com.practica.mvp.domain.interactor.UseCaseFactory
import com.practica.mvp.platform.views.MovieListActivity
import com.practica.mvp.presentation.formatters.Formatter
import com.practica.mvp.presentation.presenters.MovieListPresenter
import dagger.Module
import dagger.Provides


@Module
class ListActivityModule {

    @Provides
    internal fun providePresenter(activity: MovieListActivity, useCaseFactory: UseCaseFactory,
                                  formatter: Formatter): MovieListPresenter {
        val presenter = MovieListPresenter(useCaseFactory, formatter)
        presenter.setView(activity)
        return presenter
    }

}