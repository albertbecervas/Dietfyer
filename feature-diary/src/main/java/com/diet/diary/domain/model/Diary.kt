package com.diet.diary.domain.model

data class Diary(val summary: Summary, val mealRegister: List<MealRegister>, val goals: Goals)