package com.practica.mvp.domain


interface Handler<T> {

    fun handle(result: T)

    fun error(exception: Exception)

}