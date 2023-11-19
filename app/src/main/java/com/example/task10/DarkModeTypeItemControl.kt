package com.example.task10

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.ImageButton
import android.widget.Switch
import com.example.task10.databinding.OptionItemRecyclerviewBinding

class DarkModeTypeItemControl {
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    fun changeVisibility(imageButton: ImageButton, context: Context, binding: OptionItemRecyclerviewBinding): Switch {
        imageButton.visibility = View.GONE
        val switch: Switch = DarkModeSwitchController(context).getSwitch()
        binding.root.addView(switch)
        return switch
    }
}