package com.abecerra.components.diary

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abecerra.components.R
import com.abecerra.components.base.BaseAdapter
import com.diet.common.model.FoodRegisterViewModel
import com.diet.common.model.MacronutrientsViewModel
import com.diet.common.model.MealRegisterViewModel
import com.diet.common.utils.inflate
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MealRegisterRecyclerAdapter :
    BaseAdapter<MealRegisterRecyclerAdapter.ViewHolder, MealRegisterViewModel>() {

    var listener : FabAddFoodListener? = null

    override fun onBindViewHolder(holder: ViewHolder, item: MealRegisterViewModel, pos: Int) {
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapter = FoodRegisterRecyclerAdapter()
        val holder = ViewHolder(adapter, parent.inflate(R.layout.view_meal_register))
        val childLayoutManager =
            LinearLayoutManager(holder.foodRecyclerView.context, RecyclerView.VERTICAL, false)
        holder.foodRecyclerView.apply {
            layoutManager = childLayoutManager
            this.adapter = adapter
            setRecycledViewPool(RecyclerView.RecycledViewPool())
        }
        return holder
    }


    inner class ViewHolder(
        private val foodRecyclerAdapter: FoodRegisterRecyclerAdapter,
        view: View
    ) :
        RecyclerView.ViewHolder(view) {
        private val mealRegisterTitle =
            view.findViewById<TextView>(R.id.textview_meal_register_title)
        private val fabFoodRegister =
            view.findViewById<FloatingActionButton>(R.id.button_meal_register_add_food)
        val foodRecyclerView = view.findViewById<RecyclerView>(R.id.recyclerview_food_register)

        fun bind(mealRegisterViewModel: MealRegisterViewModel) {
            mealRegisterTitle.text = mealRegisterViewModel.mealTitle
            foodRecyclerAdapter.setItems(
                mealRegisterViewModel.foodRegister
            )
            fabFoodRegister.setOnClickListener {
                listener?.onFabAddFoodClick(mealRegisterViewModel.mealTitle)
            }

        }

    }
}