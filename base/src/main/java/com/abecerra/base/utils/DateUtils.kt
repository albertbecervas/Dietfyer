package com.abecerra.base.utils

import java.text.SimpleDateFormat
import java.util.*

const val DATE_ddMMYYYY_FORMAT = "ddMMYYYY"

fun getStringDateByPattern(pattern: String, date : Date): String {
    val dateFormat = SimpleDateFormat(pattern, Locale.getDefault())
    return dateFormat.format(date)
}