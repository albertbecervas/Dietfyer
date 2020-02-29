package com.abecerra.core.navigation.navigator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import java.lang.ref.WeakReference

class Navigator(private val context: WeakReference<Context>?) {

    fun replaceFragment(fragment: Fragment, layout: Int) {
        when (context?.get()) {
            is AppCompatActivity -> {
                (context.get() as AppCompatActivity).supportFragmentManager.beginTransaction()
                    .add(layout, fragment).commit()
            }
        }
    }

}