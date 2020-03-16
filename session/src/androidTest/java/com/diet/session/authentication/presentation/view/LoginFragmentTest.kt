package com.diet.session.authentication.presentation.view

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.diet.session.R
import com.diet.session.utils.EditTextViewMatcher.isErrorShown
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginFragmentTest {

    @Before
    fun setUp() {
        launchFragmentInContainer<LoginFragment>(factory = LoginFragmentFactory())
    }

    @Test
    fun testErrorIsShownIfUsernameIsEmptyOnLogin() {
        onView(withId(R.id.bt_login)).perform(click())
        onView(withId(R.id.et_username)).check(matches(isErrorShown()))
    }

    @Test
    fun testErrorIsShownIfPasswordIsEmptyOnLogin() {
        onView(withId(R.id.bt_login)).perform(click())
        onView(withId(R.id.et_password)).check(matches(isErrorShown()))
    }
}