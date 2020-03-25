package com.abecerra.base.presentation

interface BaseView {

    fun showErrorMessage(error: String)

    fun showProgressBar()

    fun hideProgressBar()
}