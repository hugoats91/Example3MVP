package com.practica.mvp.platform.di


import com.practica.mvp.platform.di.detail.DetailActivityModule
import com.practica.mvp.platform.di.list.ListActivityModule
import com.practica.mvp.platform.views.DetailMovieActivity
import com.practica.mvp.platform.views.MovieListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(ListActivityModule::class)])
    @PerActivity
    internal abstract fun bindListActivity(): MovieListActivity

    @ContributesAndroidInjector(modules = [(DetailActivityModule::class)])
    @PerActivity
    internal abstract fun bindDetailActivity(): DetailMovieActivity

}