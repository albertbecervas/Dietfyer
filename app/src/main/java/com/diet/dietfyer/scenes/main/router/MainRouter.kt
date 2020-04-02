package com.diet.dietfyer.scenes.main.router

import androidx.annotation.IdRes

interface MainRouter {
    fun loadDefaultFragment(@IdRes layout: Int)
    fun loaddiaryFragment(@IdRes layout: Int)
}