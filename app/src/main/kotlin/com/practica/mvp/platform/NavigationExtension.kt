package com.practica.mvp.platform

import android.app.Activity
import com.practica.mvp.platform.views.DetailMovieActivity


fun Activity.navigateToDetail(movieId: Int){
    DetailMovieActivity.launch(this, movieId)
}