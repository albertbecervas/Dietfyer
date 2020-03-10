package com.abecerra.base.data

interface BaseRepository<OUTPUT> {

    fun setOutput(output: OUTPUT)
}