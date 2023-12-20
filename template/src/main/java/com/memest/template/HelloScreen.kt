package com.memest.template

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.Action
import androidx.car.app.model.Pane
import androidx.car.app.model.PaneTemplate
import androidx.car.app.model.Row
import androidx.car.app.model.Template

class HelloScreen(carContext: CarContext) : Screen(carContext) {
    private var countClick = 0
    override fun onGetTemplate(): Template {
        val row = Row.Builder()
            .setTitle("Click count: $countClick")
            .build()
        val pane = Pane.Builder()
            .addRow(row)
            .addAction(Action.Builder()
                .setTitle("Increase")
                .setOnClickListener { onIncreaseClick() }
                .build())
            .addAction(Action.Builder()
                .setTitle("Reset")
                .setOnClickListener { onResetClick() }
                .build())
            .build()

        return PaneTemplate.Builder(pane)
            .setHeaderAction(Action.APP_ICON)
            .build()
    }

    private fun onIncreaseClick() {
        countClick++
        invalidate()
    }

    private fun onResetClick() {
        countClick = 0
        invalidate()
    }
}