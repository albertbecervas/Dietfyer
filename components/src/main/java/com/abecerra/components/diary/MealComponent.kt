package com.abecerra.components.diary

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.abecerra.components.R
import kotlinx.android.synthetic.main.food_register_item.view.*
import kotlinx.android.synthetic.main.view_meal_register.view.*

class MealComponent : ConstraintLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    )

    init {
        LinearLayout.inflate(context, R.layout.view_meal_register, this)
    }


}