package ru.netology.nmedia.util

import android.content.Context
import kotlin.math.ceil

object AndroidUtils {

    //Здесь важно то, что размеры приходят в pixel'ах:
    //формулу перевода dp в px: px=pd * (dpi/160)
    fun dp(context: Context, dp: Float): Int =
        ceil(context.resources.displayMetrics.density * dp).toInt()
}