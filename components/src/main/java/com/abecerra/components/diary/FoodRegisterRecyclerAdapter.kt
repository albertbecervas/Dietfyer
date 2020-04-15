package com.abecerra.components.diary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abecerra.components.R
import com.abecerra.components.base.BaseAdapter
import com.diet.common.model.FoodRegisterViewModel

class FoodRegisterRecyclerAdapter :
    BaseAdapter<FoodRegisterRecyclerAdapter.ViewHolder, FoodRegisterViewModel>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.food_register_item, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, item: FoodRegisterViewModel, pos: Int) {
        holder.bind(item)
    }

    class ViewHolder(foodRegisterItem: View) :
        RecyclerView.ViewHolder(foodRegisterItem) {
        private val foodRegisterItemName =
            foodRegisterItem.findViewById<TextView>(R.id.food_register_item_textview_foodname)
        private val foodRegisterItemCalories =
            foodRegisterItem.findViewById<TextView>(R.id.food_register_item_textview_calories)
        private val foodRegisterItemProtein =
            foodRegisterItem.findViewById<TextView>(R.id.food_register_item_textview_protein)
        private val foodRegisterItemCarbohydrates =
            foodRegisterItem.findViewById<TextView>(R.id.food_register_item_textview_carbh)
        private val foodRegisterItemFat =
            foodRegisterItem.findViewById<TextView>(R.id.food_register_item_textview_fat)

        fun bind(foodRegisterItemViewModel: FoodRegisterViewModel) {
            with(foodRegisterItemViewModel) {
                foodRegisterItemName.text = foodName
                foodRegisterItemCalories.text = calories.toString()
                with(macronutrients) {
                    foodRegisterItemProtein.text = protein.toString()
                    foodRegisterItemCarbohydrates.text = carbohydrates.toString()
                    foodRegisterItemFat.text = fat.toString()
                }
            }
        }

    }

}