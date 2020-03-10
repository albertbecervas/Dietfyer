package com.abecerra.base.data

abstract class BaseRepositoryImpl<OUTPUT> : BaseRepository<OUTPUT> {

    protected var output: OUTPUT? = null

    override fun setRepositoryOutput(output: OUTPUT) {
        this.output = output
    }
}