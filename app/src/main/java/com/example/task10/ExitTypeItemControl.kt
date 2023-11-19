package com.example.task10

import android.view.View
import android.widget.ImageButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat

class ExitTypeItemControl {
    fun changeVisibility(textView: AppCompatTextView, imageButton: ImageButton){
        textView.setTextColor(
            ContextCompat.getColor(
                textView.context,
                R.color.red
            )
        )
        imageButton.visibility = View.GONE
    }
}