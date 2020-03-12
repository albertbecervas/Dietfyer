package com.abecerra.base.data

interface BaseRepository<OUTPUT> {

    fun setRepositoryOutput(output: OUTPUT)
}