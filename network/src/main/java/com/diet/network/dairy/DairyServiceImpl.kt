package com.diet.network.dairy

import com.abecerra.base.utils.IntConstants
import com.diet.network.dairy.model.DairyDto
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class DairyServiceImpl : DairyService {
    companion object {
        const val DAIRY_COLLECTION_PATH = "dairy"
        const val USER_ID_DICTIONARY = "userId"
    }

    override fun getDairy(
        userId: String,
        success: (dairyDto: DairyDto) -> Unit,
        error: () -> Unit
    ) {
        val database = FirebaseFirestore.getInstance()
        database.collection(DAIRY_COLLECTION_PATH).whereEqualTo(USER_ID_DICTIONARY, userId)
            .get().addOnCompleteListener() {
                if (!it.result?.documents.isNullOrEmpty()) {
                    it.result?.documents?.get(IntConstants.FIRST_POSITION)
                        ?.toObject(DairyDto::class.java)?.let { dairy -> success(dairy) } ?: error()
                }
            }
    }

    override fun getDairy(
        userId: String,
        date: Date,
        success: (dairyDto: DairyDto) -> Unit,
        error: () -> Unit
    ) {
        TODO("Not yet implemented")
    }

}