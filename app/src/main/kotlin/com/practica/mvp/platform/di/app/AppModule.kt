package com.practica.mvp.platform.di.app

import android.app.Application
import android.content.Context
import com.practica.mvp.data.MoviesRepositoryImpl
import com.practica.mvp.data.entity.mapper.EntityDataMapper
import com.practica.mvp.data.executor.JobThread
import com.practica.mvp.data.source.local.MoviesLocalDataSource
import com.practica.mvp.data.source.local.MoviesLocalDataSourceImpl
import com.practica.mvp.data.source.remote.MovieService
import com.practica.mvp.data.source.remote.MoviesRemoteDataSource
import com.practica.mvp.data.source.remote.MoviesRemoteDataSourceImpl
import com.practica.mvp.domain.MoviesRepository
import com.practica.mvp.domain.executor.JobScheduler
import com.practica.mvp.domain.executor.UIScheduler
import com.practica.mvp.platform.executor.UIThread
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    internal fun provideService(): MovieService {
        return Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create<MovieService>(MovieService::class.java)
    }

    @Provides
    @Singleton
    internal fun provideLocalDataSource(): MoviesLocalDataSource {
        return MoviesLocalDataSourceImpl()
    }

    @Provides
    @Singleton
    internal fun provideRemoteDataSource(movieService: MovieService): MoviesRemoteDataSource {
        return MoviesRemoteDataSourceImpl(movieService)
    }

    @Provides
    @Singleton
    internal fun provideRepository(localDataSource: MoviesLocalDataSource,
                                   remoteDataSource: MoviesRemoteDataSource,
                                   entityDataMapper: EntityDataMapper): MoviesRepository {
        return MoviesRepositoryImpl(localDataSource, remoteDataSource, entityDataMapper)
    }

    @Provides
    @Singleton
    internal fun provideUIScheduler(): UIScheduler {
        return UIThread()
    }

    @Provides
    @Singleton
    internal fun provideJobScheduler(): JobScheduler {
        return JobThread()
    }

}
