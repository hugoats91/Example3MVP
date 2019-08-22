package com.practica.mvp.domain.executor

import io.reactivex.Scheduler


interface UIScheduler {
    fun getScheduler(): Scheduler
}