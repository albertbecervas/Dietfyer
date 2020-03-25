package com.diet.dietfyer.scenes.main.router

import androidx.annotation.IdRes

interface MainRouter {
    fun loadDefaultFragment(@IdRes layout: Int)
    fun loadDairyFragment(@IdRes layout: Int)
}