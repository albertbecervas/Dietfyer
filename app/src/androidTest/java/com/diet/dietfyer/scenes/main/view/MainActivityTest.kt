package com.diet.dietfyer.scenes.main.view

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.diet.session.LoginPresenter
import com.diet.session.LoginView
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val testRule: ActivityTestRule<MainActivity> =
        ActivityTestRule(MainActivity::class.java, false, false)

    @Mock
    lateinit var presenter: LoginPresenter

    @Mock
    lateinit var view: LoginView

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testOnCreate() {
        testRule.launchActivity(null)
        verify(presenter, times(1)).setView(view)
    }
}