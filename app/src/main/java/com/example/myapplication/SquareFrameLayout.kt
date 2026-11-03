package com.example.listhomework

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout

class SquareFrameLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    override fun onMeasure(
        widthMeasureSpec: Int,
        heightMeasureSpec: Int
    ) {
        val width = View.MeasureSpec.getSize(widthMeasureSpec)

        val squareMeasureSpec = View.MeasureSpec.makeMeasureSpec(
            width,
            View.MeasureSpec.EXACTLY
        )

        super.onMeasure(
            squareMeasureSpec,
            squareMeasureSpec
        )
    }
}