package com.diet.dietfyer.scenes.main.presenter

import com.diet.dietfyer.R
import com.diet.dietfyer.scenes.main.router.MainRouter
import com.diet.dietfyer.scenes.main.view.MainView
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class MainPresenterImplTest {

    private lateinit var presenter: MainPresenterImpl

    @Mock
    lateinit var view: MainView

    @Mock
    lateinit var router: MainRouter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = MainPresenterImpl(router)
        presenter.setView(view)
    }

    @Test
    fun loadHomeFragment() {
        presenter.loadHomeFragment()
        verify(router, times(1)).loadDefaultFragment(R.id.base_fl)
    }

    @Test
    fun getNavigationItems() {
        assert(presenter.getNavigationItems().isNotEmpty())
        assert(presenter.getNavigationItems().size <= MAX_NAV_ITEMS)
    }

    companion object {
        const val MAX_NAV_ITEMS = 5
    }
}