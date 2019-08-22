package com.practica.mvp.platform.views

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import kotlin.math.max


class AutofitRecyclerView: RecyclerView {

    private lateinit var manager: GridLayoutManager
    private var columnWidth = -1

    constructor(context: Context) : super(context){
        create(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs){
        create(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle){
        create(context, attrs)
    }

    private fun create(context: Context, attrs: AttributeSet?){
        if(attrs!=null){
            val attrsArray = intArrayOf(android.R.attr.columnWidth)
            val typedArray = context.obtainStyledAttributes(attrs, attrsArray)
            columnWidth = typedArray.getDimensionPixelSize(0, -1)
            typedArray.recycle()
        }

        manager = GridLayoutManager(getContext(), 1)
        layoutManager = manager
    }

    override fun onMeasure(widthSpec: Int, heightSpec: Int) {
        super.onMeasure(widthSpec, heightSpec)
        if(columnWidth>0){
            manager.spanCount = max(1, measuredWidth/columnWidth)
        }
    }

}