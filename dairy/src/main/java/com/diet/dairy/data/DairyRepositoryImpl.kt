package com.diet.dairy.data

import com.abecerra.base.data.BaseRepositoryImpl
import com.diet.dairy.domain.repository.DairyRepository
import com.diet.dairy.domain.repository.DairyRepositoryOutput
import com.diet.network.dairy.DairyService
import com.diet.session.user.data.UserDataSource

class DairyRepositoryImpl(
    private val userDataSource: UserDataSource,
    private val dairyService: DairyService
) : BaseRepositoryImpl<DairyRepositoryOutput>(), DairyRepository {

    override fun getCurrentDayDairy() {
        dairyService.getDairy(
            userDataSource.getCurrentUserId(),
            { output?.onSuccessFetchUserDairy(it.toDairy()) },
            { output?.onErrorFetchUserDairy("Unexpected error ocurred") })
    }

}