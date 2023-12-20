package com.memest.template

import android.content.Intent
import androidx.car.app.Screen
import androidx.car.app.Session

class HelloSession : Session() {
    override fun onCreateScreen(intent: Intent): Screen {
        return HelloScreen(carContext)
    }
}