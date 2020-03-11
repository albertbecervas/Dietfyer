package com.diet.dietfyer.navigation.navigator

import android.content.Intent
import androidx.fragment.app.Fragment

interface Navigator {

    fun startActivityForResult(intent: Intent, resultCode: Int, fragment: Fragment)

    fun replaceFragment(fragment: Fragment, layout: Int)
}