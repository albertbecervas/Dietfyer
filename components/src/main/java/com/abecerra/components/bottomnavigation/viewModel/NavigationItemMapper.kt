package com.abecerra.components.bottomnavigation.viewModel

import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem

object NavigationItemMapper {

    private fun NavigationItem.mapToAhBottomNavigationItem(): AHBottomNavigationItem {
        return AHBottomNavigationItem(name, icon)
    }

    fun mapToAhBottomNavigationItems(items: List<NavigationItem>): List<AHBottomNavigationItem> {
        return items.map { it.mapToAhBottomNavigationItem() }
    }
}