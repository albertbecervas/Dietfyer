package com.diet.dietfyer.di.module.presentation

import android.content.Context
import com.diet.diary.presentation.presenter.DiaryPresenter
import com.diet.diary.presentation.view.DiaryFragment
import com.diet.session.login.view.LoginFragment
import com.diet.session.login.presenter.LoginPresenter
import dagger.Module
import dagger.Provides

@Module
open class ViewModule(private val context: Context) {

    @Provides
    open fun provideContext(): Context = context

    @Provides
    open fun provideLoginFragment(loginPresenter: LoginPresenter): LoginFragment {
        val loginFragment = LoginFragment()
        loginFragment.injectPresenter(loginPresenter)
        return loginFragment
    }

    @Provides
    open fun provideDiaryFragment(DiaryPresenter : DiaryPresenter) : DiaryFragment {
        val diaryFragment = DiaryFragment()
        diaryFragment.injectPresenter(DiaryPresenter)
        return diaryFragment
    }
}