package com.diet.dietfyer.scenes.presentation.view

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.diet.dietfyer.DaggerTestViewComponent
import com.diet.dietfyer.TestPresenterModule
import com.diet.dietfyer.di.module.presentation.ViewModule
import com.diet.session.LoginPresenter
import com.diet.session.LoginView
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val testRule: ActivityTestRule<MainActivity> =
        ActivityTestRule(MainActivity::class.java, false, true)

    @Inject
    lateinit var presenter: LoginPresenter

    @Mock
    lateinit var view: LoginView

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        DaggerTestViewComponent.builder().viewModule(ViewModule(testRule.activity)).build()
            .inject(this)
    }

    @Test
    fun testOnCreate() {
        //testRule.launchActivity(null)
        presenter.setView(view)
    }

}