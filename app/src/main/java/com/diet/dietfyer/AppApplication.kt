package com.diet.dietfyer

import androidx.multidex.MultiDexApplication

class AppApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    companion object {
        private lateinit var INSTANCE: AppApplication

        fun getInstance(): AppApplication {
            return INSTANCE
        }
    }
}