package com.diet.network.diary

import com.abecerra.base.utils.IntConstants
import com.diet.network.diary.model.DiaryDto
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class DiaryServiceImpl : DiaryService {
    companion object {
        const val diary_COLLECTION_PATH = "diary"
        const val USER_ID_DICTIONARY = "userId"
    }

    override fun getDiary(
        userId: String,
        success: (diaryDto: DiaryDto) -> Unit,
        error: () -> Unit
    ) {
        val database = FirebaseFirestore.getInstance()
        database.collection(diary_COLLECTION_PATH).whereEqualTo(USER_ID_DICTIONARY, userId)
            .get().addOnCompleteListener() {
                if (!it.result?.documents.isNullOrEmpty()) {
                    it.result?.documents?.get(IntConstants.FIRST_POSITION)
                        ?.toObject(DiaryDto::class.java)?.let { diary -> success(diary) }
                        ?: success(
                            DiaryDto()
                        )
                } else {
                    success(DiaryDto())
                }
            }.addOnFailureListener { error() }
    }

    override fun getDiary(
        userId: String,
        date: Date,
        success: (diaryDto: DiaryDto) -> Unit,
        error: () -> Unit
    ) {
        TODO("Not yet implemented")
    }

}