package com.diet.base.domain

interface BaseInteractor<OUTPUT> {

    fun setOutput(output: OUTPUT)
}