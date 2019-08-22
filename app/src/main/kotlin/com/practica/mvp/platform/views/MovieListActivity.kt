package com.practica.mvp.platform.views

import android.os.Bundle
import com.practica.mvp.R
import com.practica.mvp.platform.navigateToDetail
import com.practica.mvp.presentation.MovieListView
import com.practica.mvp.presentation.presenters.MovieListPresenter
import kotlinx.android.synthetic.main.activity_movie_list.*
import javax.inject.Inject


class MovieListActivity : BaseActivity(), MovieListView {

    @Inject lateinit var presenter: MovieListPresenter

    private lateinit var adapter: MoviesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        setUpActionBar()

        setUpListView()

        setUpRefreshView()

        informPresenterViewIsReady()
    }

    private fun setUpActionBar() {
        setSupportActionBar(toolbar)
    }

    private fun setUpListView() {
        adapter = MoviesAdapter(presenter)
        recyclerView.adapter = adapter
    }

    private fun setUpRefreshView() {
        refreshLayout.setColorSchemeResources(
                R.color.colorPrimary,
                R.color.colorPrimaryDark,
                R.color.colorAccent)
        refreshLayout.setOnRefreshListener { presenter.refresh() }
    }

    private fun informPresenterViewIsReady() {
        presenter.viewReady()
    }

    override fun refreshList() {
        adapter.refreshData()
    }

    override fun cancelRefreshDialog() {
        refreshLayout.isRefreshing = false
    }

    override fun navigateToDetailScreen(movieId: Int) {
        navigateToDetail(movieId)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

}
