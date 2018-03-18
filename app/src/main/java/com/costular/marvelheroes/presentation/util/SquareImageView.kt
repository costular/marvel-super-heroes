package com.costular.marvelheroes.presentation.util

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView

/**
 * Created by costular on 17/03/2018.
 */
class SquareImageView(context: Context, attributes: AttributeSet) : ImageView(context, attributes) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val width = measuredWidth
        setMeasuredDimension(width, width)
    }

}