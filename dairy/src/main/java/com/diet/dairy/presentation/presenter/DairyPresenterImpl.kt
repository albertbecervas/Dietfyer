package com.diet.dairy.presentation.presenter

import com.abecerra.base.presentation.BasePresenterImpl
import com.diet.dairy.domain.interactor.DairyInteractor
import com.diet.dairy.domain.interactor.DairyInteractorOutput
import com.diet.dairy.domain.model.Dairy
import com.diet.dairy.presentation.router.DairyRouter
import com.diet.dairy.presentation.toDairyViewModel
import com.diet.dairy.presentation.view.DairyView

class DairyPresenterImpl(
    private val dairyRouter: DairyRouter,
    private val dairyInteractor: DairyInteractor
) : BasePresenterImpl<DairyView>(),
    DairyPresenter, DairyInteractorOutput {

    init {
        dairyInteractor.setInteractorOutput(this)
    }
    override fun getCurrentDayDairy() {
        getView()?.showProgressBar()
        dairyInteractor.getCurrentDayDairy()
    }

    override fun onSuccessFetchUserDairy(model: Dairy) {
        getView()?.hideProgressBar()
        getView()?.showDairy(model.toDairyViewModel())
    }

    override fun onErrorFetchUserDairy(errorMessage : String) {
        showError(errorMessage)
    }

}