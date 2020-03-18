package com.diet.dietfyer.navigation.navigator

import android.content.Intent
import androidx.fragment.app.Fragment
import kotlin.reflect.KClass

interface Navigator {

    fun startActivity(clazz: Class<*>)
    
    fun startActivityFinishingCurrent(clazz: Class<*>)

    fun startActivityForResult(intent: Intent, resultCode: Int, fragment: Fragment)

    fun replaceFragment(fragment: Fragment, layout: Int)
}