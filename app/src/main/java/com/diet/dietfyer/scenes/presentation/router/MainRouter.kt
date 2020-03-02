package com.diet.dietfyer.scenes.presentation.router

import androidx.annotation.IdRes

interface MainRouter {
    fun loadDefaultFragment(@IdRes layout: Int)
}