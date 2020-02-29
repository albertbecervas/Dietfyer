package com.diet.base.domain

interface BaseInteractor<OUTPUT> {

    fun setInteractorOutput(output: OUTPUT)
}