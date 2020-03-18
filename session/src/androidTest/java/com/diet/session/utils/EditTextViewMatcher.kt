package com.diet.session.utils

import android.view.View
import android.widget.EditText
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher

object EditTextViewMatcher {

    fun isErrorShown(): Matcher<View> {
        return object : BoundedMatcher<View, EditText>(EditText::class.java) {
            override fun describeTo(description: Description?) {
                description?.appendText("Error not shown on empty field")
            }

            override fun matchesSafely(item: EditText?): Boolean {
                return item?.error?.isNotBlank() ?: false
            }
        }
    }
}