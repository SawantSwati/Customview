package com.example.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.icu.text.ListFormatter.Width
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import kotlin.math.absoluteValue
import kotlin.random.Random

class Graphview
    (
    context: Context, attributeSet: AttributeSet?
) : AppCompatImageView(context, attributeSet) {

    constructor(context: Context) : this(context, null)

    var values: Array<Int>? = null
        set(value) {
            field = value
            invalidate()
        }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (values == null) {
            return
        }

        val paint = Paint()
        paint.color = Color.RED
        val paintText = Paint()
        paintText.color = Color.WHITE
        paintText.textSize = 30f
        var left = 0
        val rectWidth = width / (values!!.size)
        val heightToPerc = (height / 100).toFloat()

        for (value in values!!) {
            paint.color = Color.rgb(
                Random.nextInt().absoluteValue % 256,
                Random.nextInt().absoluteValue % 256,
                Random.nextInt().absoluteValue % 256

            )
            canvas!!.drawRect(
                left.toFloat(), height - heightToPerc * value,

                left.toFloat() + (rectWidth - 10).toFloat(), height.toFloat(),
                paint
            )

            canvas.drawText(
                value.toString(),
                left.toFloat(),
                height.toFloat() - 100,
                paintText
            )
            left += (width / values!!.size)
        }


    }
}