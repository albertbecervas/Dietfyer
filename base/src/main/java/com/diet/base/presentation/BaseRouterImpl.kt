package com.diet.base.presentation

import android.content.Context
import java.lang.ref.WeakReference

abstract class BaseRouterImpl<VIEW> {

    protected var viewReference: WeakReference<VIEW>? = null

    protected fun getContextFromView(): Context? {
        return viewReference?.get() as? Context
    }
}