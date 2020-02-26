package com.diet.base.data

interface BaseRepository<OUTPUT> {

    fun setOutput(output: OUTPUT)
}