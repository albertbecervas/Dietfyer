package com.diet.network.diary

import com.abecerra.base.utils.DATE_ddMMYYYY_FORMAT
import com.abecerra.base.utils.getStringDateByPattern
import com.diet.network.diary.model.DiaryDto
import com.diet.network.diary.model.MealRegisterDto
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class DiaryServiceImpl : DiaryService {
    companion object {
        const val DIARY_COLLECTION_PATH = "diary"
        const val MEAL_REGISTER_FIELD = "mealRegister"
    }

    override fun getDiary(
        userId: String,
        success: (diaryDto: DiaryDto) -> Unit,
        error: () -> Unit
    ) {
        val documentRef = FirebaseFirestore.getInstance().collection(DIARY_COLLECTION_PATH)
            .document(userId + getStringDateByPattern(DATE_ddMMYYYY_FORMAT, Date()))
        documentRef.get().addOnSuccessListener {
            it.toObject(DiaryDto::class.java)?.let { diary -> success(diary) } ?: with(DiaryDto()) {
                documentRef.set(this)
                success(this)
            }

        }.addOnFailureListener { error() }

    }

    override fun getDiary(
        userId: String,
        date: Date,
        success: (diaryDto: DiaryDto) -> Unit,
        error: () -> Unit
    ) {
        val documentRef = FirebaseFirestore.getInstance().collection(DIARY_COLLECTION_PATH)
            .document(userId + getStringDateByPattern(DATE_ddMMYYYY_FORMAT, date))
        documentRef.get().addOnSuccessListener {
            it.toObject(DiaryDto::class.java)?.let { diary -> success(diary) } ?: with(DiaryDto()) {
                documentRef.set(this)
                success(this)
            }

        }.addOnFailureListener { error() }
    }


    override fun addMeal(
        mealRegisterDto: MealRegisterDto,
        userId: String,
        date: Date,
        success: () -> Unit,
        error: () -> Unit
    ) {
        val documentRef = FirebaseFirestore.getInstance().collection(DIARY_COLLECTION_PATH)
            .document(userId + getStringDateByPattern(DATE_ddMMYYYY_FORMAT, date))
        documentRef.update(MEAL_REGISTER_FIELD, FieldValue.arrayUnion(mealRegisterDto))
            .addOnSuccessListener { success() }
            .addOnFailureListener { error() }
    }

    override fun addFoodRegisterToMeal(
        mealRegisterDtoList: List<MealRegisterDto>,
        userId: String,
        date: Date,
        success: () -> Unit,
        error: () -> Unit
    ) {
        val documentRef = FirebaseFirestore.getInstance().collection(DIARY_COLLECTION_PATH)
            .document(userId + getStringDateByPattern(DATE_ddMMYYYY_FORMAT, date))
        documentRef.update(MEAL_REGISTER_FIELD, mealRegisterDtoList)
            .addOnSuccessListener { success() }
            .addOnFailureListener { error() }
    }

}