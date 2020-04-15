package com.abecerra.components.diary

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abecerra.components.R
import com.abecerra.components.base.BaseAdapter
import com.diet.common.model.MealRegisterViewModel
import com.diet.common.utils.inflate
import kotlinx.android.synthetic.main.view_meal_register.view.*


class MealRegisterRecyclerAdapter :
    BaseAdapter<MealRegisterRecyclerAdapter.ViewHolder, MealRegisterViewModel>() {

    var listener: FabAddFoodListener? = null

    override fun onBindViewHolder(holder: ViewHolder, item: MealRegisterViewModel, pos: Int) {
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapter = FoodRegisterRecyclerAdapter()
        return ViewHolder(adapter, parent.inflate(R.layout.view_meal_register))
    }


    inner class ViewHolder(
        private val foodRecyclerAdapter: FoodRegisterRecyclerAdapter,
        private val view: View
    ) : RecyclerView.ViewHolder(view) {
        init {
            view.recyclerview_food_register.layoutManager =
                LinearLayoutManager(view.context, RecyclerView.VERTICAL, false)
            view.recyclerview_food_register.adapter = foodRecyclerAdapter
        }

        fun bind(mealRegisterViewModel: MealRegisterViewModel) {
            view.textview_meal_register_title.text = mealRegisterViewModel.mealTitle
            setTotals(mealRegisterViewModel)
            foodRecyclerAdapter.setItems(
                mealRegisterViewModel.foodRegister
            )
            view.button_meal_register_add_food.setOnClickListener {
                listener?.onFabAddFoodClick(mealRegisterViewModel.mealTitle)
            }

        }

        fun setTotals(mealRegisterViewModel: MealRegisterViewModel) {
            with(mealRegisterViewModel) {
                view.textview_meal_register_total_calories.text = totalCalories.toString()
                view.textview_meal_register_total_protein.text = total.protein.toString()
                view.textview_meal_register_total_carbohydrates.text = total.carbohydrates.toString()
                view.textview_meal_register_total_fat.text = total.fat.toString()
            }
        }

    }
}