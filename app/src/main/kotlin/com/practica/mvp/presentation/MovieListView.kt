package com.practica.mvp.presentation


interface MovieListView : BaseView {

    fun refreshList()

    fun cancelRefreshDialog()

    fun navigateToDetailScreen(movieId: Int)

}