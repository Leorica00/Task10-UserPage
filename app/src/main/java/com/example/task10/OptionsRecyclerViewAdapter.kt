package com.example.task10

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.task10.databinding.OptionItemRecyclerviewBinding

class OptionsRecyclerViewAdapter :
    ListAdapter<Option, OptionsRecyclerViewAdapter.OptionsViewHolder>(
        object : DiffUtil.ItemCallback<Option>() {

            override fun areItemsTheSame(oldItem: Option, newItem: Option): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: Option, newItem: Option): Boolean {
                return oldItem == newItem
            }
        }
    ) {

    val currentLanguage = "English(US)"
    lateinit var onSwitchCheck: (Boolean) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionsViewHolder {
        return OptionsViewHolder(
            OptionItemRecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OptionsViewHolder, position: Int) {
        holder.bind()
    }

    inner class OptionsViewHolder(private val binding: OptionItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("UseSwitchCompatOrMaterialCode")
        fun bind() {
            val options = currentList[adapterPosition]
            binding.also {
                it.iconIv.setImageResource(options.icon)
                it.titleTv.text = options.title
                when (options.type) {
                    Type.LANGUAGE -> it.languageTv.text = currentLanguage
                    Type.EXIT -> ExitTypeItemControl().changeVisibility(binding.titleTv, binding.itemArrow)
                    Type.DARK_MODE -> {
                        val switch = DarkModeTypeItemControl().changeVisibility(it.itemArrow, binding.root.context, binding)
                        switch.setOnCheckedChangeListener { _, isChecked ->
                            onSwitchCheck.invoke(isChecked)
                        }
                    }
                    else -> {}
                }
            }
        }
    }
}