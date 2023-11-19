package com.example.task10

import android.annotation.SuppressLint
import android.content.Context
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate

class DarkModeSwitchController(context: Context) {

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private val switch: Switch = Switch(context)

    init {
        switch.isChecked = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES
        val layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.WRAP_CONTENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.gravity =
            Gravity.END or Gravity.CENTER_VERTICAL
        switch.layoutParams = layoutParams
    }

    fun getSwitch(): Switch {
        return switch
    }
}