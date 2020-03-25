package com.diet.dairy.domain.interactor

import com.diet.dairy.domain.model.Dairy

interface DairyInteractorOutput {
    fun onSuccessFetchUserDairy(model: Dairy)
    fun onErrorFetchUserDairy(errorMessage : String)
}