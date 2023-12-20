package com.memest.template

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.Action
import androidx.car.app.model.CarIcon
import androidx.car.app.model.ItemList
import androidx.car.app.model.ListTemplate
import androidx.car.app.model.Row
import androidx.car.app.model.SectionedItemList
import androidx.car.app.model.Template
import androidx.core.graphics.drawable.IconCompat

class ListScreen(carContext: CarContext) : Screen(carContext) {
    private val itemList by lazy {
        val icon = CarIcon.Builder(
            IconCompat.createWithResource(
                carContext,
                R.drawable.baseline_check_24
            )
        ).build()

        ItemList.Builder()
            .addItem(Row.Builder().setImage(icon).setTitle("Item 1").build())
            .addItem(Row.Builder().setImage(icon).setTitle("Item 2").build())
            .addItem(Row.Builder().setImage(icon).setTitle("Item 3").build())
            .addItem(Row.Builder().setImage(icon).setTitle("Item 4").build())
            .build()
    }

    override fun onGetTemplate(): Template {
        return ListTemplate.Builder()
            .setHeaderAction(Action.BACK)
            .setTitle("List Preview")
            .addSectionedList(SectionedItemList.create(itemList, "Header"))

            .build()
    }

}