package com.abecerra.base.presentation

interface BasePresenter<VIEW> {

    fun setView(view: VIEW)

}