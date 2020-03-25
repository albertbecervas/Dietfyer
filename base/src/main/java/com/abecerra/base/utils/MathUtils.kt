package com.abecerra.base.utils

import kotlin.math.roundToInt

/**
 * Function that return the part in % from the first value to the second value
 */
fun calculatePercent(firstValue: Int, secondValue: Int): Int {
    return if (secondValue == 0) 0
    else
        ((firstValue.toDouble() / secondValue) * 100).roundToInt()
}