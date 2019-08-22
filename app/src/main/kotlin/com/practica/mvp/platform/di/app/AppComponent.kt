package com.practica.mvp.platform.di.app

import android.app.Application
import com.practica.mvp.platform.MoviesApp
import com.practica.mvp.platform.di.ActivityBuilder
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityBuilder::class])
interface AppComponent: AndroidInjector<MoviesApp> {

    override fun inject(app: MoviesApp)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

}