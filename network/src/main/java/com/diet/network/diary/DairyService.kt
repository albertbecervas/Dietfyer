package com.diet.network.diary

import com.diet.network.diary.model.DiaryDto
import java.util.*

interface DiaryService {

    fun getDiary(userId: String, success: (diaryDto: DiaryDto) -> Unit, error: () -> Unit)

    fun getDiary(userId: String, date: Date, success: (diaryDto: DiaryDto) -> Unit, error: () -> Unit)
}