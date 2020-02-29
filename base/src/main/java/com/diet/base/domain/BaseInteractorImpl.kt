package com.diet.base.domain

abstract class BaseInteractorImpl<OUTPUT> : BaseInteractor<OUTPUT> {

    protected var output: OUTPUT? = null

    override fun setInteractorOutput(output: OUTPUT) {
        this.output = output
    }
}