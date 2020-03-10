package com.abecerra.base.utils

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerPaginationListener(
    private val loadMore: RecyclerPaginationListener.(page: Int) -> Unit
) :
    RecyclerView.OnScrollListener() {

    var isLoading = true
    var currentOffset = 0

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        when (newState) {
            RecyclerView.SCROLL_STATE_IDLE -> {
                val layoutManager = if (recyclerView.layoutManager is LinearLayoutManager) {
                    recyclerView.layoutManager as LinearLayoutManager
                } else {
                    recyclerView.layoutManager as GridLayoutManager
                }

                val totalItems = layoutManager.itemCount
                val lastVisibleItem = layoutManager.findLastVisibleItemPosition()

                if (lastVisibleItem != 0 && lastVisibleItem == totalItems - 1 && !isLoading) {
                    currentOffset = totalItems
                    isLoading = true
                    loadMore(currentOffset)
                }
            }
        }
    }

    fun setEndLoading() {
        this.isLoading = false
    }
}