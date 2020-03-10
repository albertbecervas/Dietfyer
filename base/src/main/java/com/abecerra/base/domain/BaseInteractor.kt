package com.abecerra.base.domain

interface BaseInteractor<OUTPUT> {

    fun setInteractorOutput(output: OUTPUT)
}