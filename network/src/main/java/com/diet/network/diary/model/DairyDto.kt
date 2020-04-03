package com.diet.network.diary.model

import com.google.firebase.firestore.PropertyName

data class DiaryDto(
    @get:PropertyName("summary") @set:PropertyName("summary") var summaryDto: SummaryDto = SummaryDto(),
    @get:PropertyName("mealRegister") @set:PropertyName("mealRegister") var mealRegisterDto: List<MealRegisterDto> = listOf(),
    @get:PropertyName("goals") @set:PropertyName("goals") var goalsDto: GoalsDto = GoalsDto()
)
