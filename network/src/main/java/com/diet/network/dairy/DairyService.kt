package com.diet.network.dairy

import com.diet.network.dairy.model.DairyDto
import java.util.*

interface DairyService {

    fun getDairy(userId: String, success: (dairyDto: DairyDto) -> Unit, error: () -> Unit)

    fun getDairy(userId: String, date: Date, success: (dairyDto: DairyDto) -> Unit, error: () -> Unit)
}