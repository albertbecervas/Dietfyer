package com.diet.base.presentation

interface BasePresenter<VIEW> {

    fun setView(view: VIEW)

}