package com.diet.diary.presentation.view

import android.os.Bundle
import android.view.View
import com.abecerra.base.presentation.BasePresenterFragment
import com.diet.diary.R
import com.diet.diary.presentation.model.DiaryViewModel
import com.diet.diary.presentation.model.SummaryViewModel
import com.diet.diary.presentation.presenter.DiaryPresenter
import kotlinx.android.synthetic.main.fragment_diary.*
import kotlin.math.roundToInt

class DiaryFragment : BasePresenterFragment<DiaryPresenter>(R.layout.fragment_diary), DiaryView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter?.setView(this)
        presenter?.getCurrentDaydiary()
    }

    override fun showEmptyDiary() {
        textview_diary_no_data.visibility = View.VISIBLE
    }

    override fun showDiary(diary: DiaryViewModel) {
        fillProgressBars(diary.summary)
        fillSummaryTextViews(diary.summary)
    }

    private fun fillProgressBars(summaryViewModel: SummaryViewModel) {
        with(summaryViewModel) {
            progress_summary_calories.progress = caloriesPercent
            with(macronutrients) {
                progress_summary_protein.progress = proteinPercent
                progress_summary_carbohydrates.progress = carbohydratesPercent
                progress_summary_fat.progress = fatPercent
            }
        }
    }

    private fun fillSummaryTextViews(summaryViewModel: SummaryViewModel) {
        with(summaryViewModel) {
            textview_summary_calories_value.text = calories.toString()
            with(macronutrients) {
                textview_summary_protein_value.text = protein.toString()
                textview_summary_carbohydrates_value.text = carbohydrates.toString()
                textview_summary_fat_value.text = fat.toString()
            }
        }
    }
}