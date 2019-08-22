package com.practica.mvp.domain.executor

import io.reactivex.Scheduler


interface JobScheduler {
    fun getScheduler(): Scheduler
}