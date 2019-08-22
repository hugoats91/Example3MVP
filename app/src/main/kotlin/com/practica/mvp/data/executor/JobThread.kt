package com.practica.mvp.data.executor

import com.practica.mvp.domain.executor.JobScheduler
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class JobThread: JobScheduler {
    override fun getScheduler(): Scheduler = Schedulers.io()
}