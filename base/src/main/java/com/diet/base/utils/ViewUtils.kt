package com.diet.base.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import java.time.Duration

fun inflate(parent: ViewGroup, layout: Int): View {
    return LayoutInflater.from(parent.context).inflate(layout, parent, false)
}

fun Context.toast(message: String, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, duration).show()
}