package com.practica.mvp.data.source.local

import android.content.Context
import com.practica.mvp.data.entity.MyObjectBox
import io.objectbox.BoxStore

object ObjectBox {

    lateinit var boxStore: BoxStore
        private set

    fun build(context: Context) {
        boxStore = MyObjectBox.builder().androidContext(context).build()
    }

    fun clear() {
        boxStore.close()
        boxStore.deleteAllFiles()
    }
}