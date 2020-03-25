package com.diet.dairy.domain.interactor

import com.abecerra.base.domain.BaseInteractorImpl
import com.diet.dairy.domain.model.Dairy
import com.diet.dairy.domain.repository.DairyRepository
import com.diet.dairy.domain.repository.DairyRepositoryOutput

class DairyInteractorImpl(private val dairyRepository: DairyRepository) :
    BaseInteractorImpl<DairyInteractorOutput>(), DairyInteractor, DairyRepositoryOutput {

    init {
        dairyRepository.setRepositoryOutput(this)
    }

    override fun getCurrentDayDairy() {
        dairyRepository.getCurrentDayDairy()
    }

    override fun onSuccessFetchUserDairy(model: Dairy) {
        output?.onSuccessFetchUserDairy(model)
    }

    override fun onErrorFetchUserDairy(errorMessage: String) {
        output?.onErrorFetchUserDairy(errorMessage)
    }
}