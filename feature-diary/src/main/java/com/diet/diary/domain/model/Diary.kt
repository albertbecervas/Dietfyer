package com.diet.diary.domain.model

data class Diary(val summary: Summary, val foodRegister: List<FoodRegister>, val goals: Goals)