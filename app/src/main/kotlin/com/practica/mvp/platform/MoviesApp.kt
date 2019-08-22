package com.practica.mvp.platform

import com.practica.mvp.data.source.local.ObjectBox
import com.practica.mvp.platform.di.app.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication


class MoviesApp: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<MoviesApp> {
        return DaggerAppComponent.builder().application(this).build()
    }

    override fun onCreate() {
        super.onCreate()
        ObjectBox.build(this)
    }

}