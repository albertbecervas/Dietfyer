package com.diet.dairy.domain.repository

import com.diet.dairy.domain.model.Dairy

interface DairyRepositoryOutput {

    fun onSuccessFetchUserDairy(model : Dairy)
    fun onErrorFetchUserDairy(errorMessage : String)

}