package com.diet.dietfyer.navigation.navigator

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import java.lang.ref.WeakReference

class NavigatorImpl(private val context: WeakReference<Context?>?) : Navigator {

    override fun startActivityForResult(intent: Intent, resultCode: Int, fragment: Fragment) {
        fragment.startActivityForResult(intent, resultCode)
    }

    override fun replaceFragment(fragment: Fragment, layout: Int) {
        when (context?.get()) {
            is AppCompatActivity -> {
                (context.get() as AppCompatActivity).supportFragmentManager.beginTransaction()
                    .add(layout, fragment).commit()
            }
        }
    }

}