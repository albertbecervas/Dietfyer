package com.diet.dairy.presentation.view

import android.os.Bundle
import android.view.View
import com.abecerra.base.presentation.BasePresenterFragment
import com.diet.dairy.R
import com.diet.dairy.presentation.model.DairyViewModel
import com.diet.dairy.presentation.model.SummaryViewModel
import com.diet.dairy.presentation.presenter.DairyPresenter
import com.diet.network.dairy.model.DairyDto
import kotlinx.android.synthetic.main.fragment_dairy.*
import kotlin.math.roundToInt

class DairyFragment : BasePresenterFragment<DairyPresenter>(R.layout.fragment_dairy), DairyView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter?.setView(this)
        presenter?.getCurrentDayDairy()
    }

    override fun showDairy(dairy: DairyViewModel) {
        fillProgressBars(dairy)
        fillSummaryTextViews(dairy.summary)
    }

    private fun fillProgressBars(dairy: DairyViewModel) {
        with(dairy) {
            progress_summary_calories.progress = (summary.calories.toDouble() / goals.calories * 100).roundToInt()
            progress_summary_protein.progress =
                (summary.macronutrients.protein.toDouble() / goals.macronutrients.protein * 100).roundToInt()
            progress_summary_carbohydrates.progress =
                (summary.macronutrients.carbohydrates.toDouble() / goals.macronutrients.carbohydrates * 100).roundToInt()
            progress_summary_fat.progress =
                (summary.macronutrients.fat.toDouble() / goals.macronutrients.fat * 100).roundToInt()
        }
    }

    private fun fillSummaryTextViews(summaryViewModel: SummaryViewModel) {
        with(summaryViewModel) {
            textview_summary_calories_value.text = calories.toString()
            textview_summary_protein_value.text = macronutrients.protein.toString()
            textview_summary_carbohydrates_value.text = macronutrients.carbohydrates.toString()
            textview_summary_fat_value.text = macronutrients.fat.toString()
        }
    }
}