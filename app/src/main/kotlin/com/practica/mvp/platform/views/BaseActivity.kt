package com.practica.mvp.platform.views

import android.support.v7.app.AlertDialog
import com.practica.mvp.R
import com.practica.mvp.presentation.BaseView
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity(), BaseView {

    override fun showErrorMessage(message: String) {
        val builder = AlertDialog.Builder(this,
                R.style.Theme_AppCompat_Light_Dialog_Alert)
        builder.setMessage(message)
        builder.setPositiveButton(android.R.string.ok){ dialog, _ ->
            dialog.dismiss()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

}
