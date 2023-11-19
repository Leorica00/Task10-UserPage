package com.example.task10

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var optionsRecyclerViewAdapter: OptionsRecyclerViewAdapter
    private lateinit var optionsRecyclerView: RecyclerView
    private lateinit var options: List<Option>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUp()
    }

    private fun setUp() {
        setOptions()
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        optionsRecyclerView = binding.optionsRecyclerview
        optionsRecyclerViewAdapter = OptionsRecyclerViewAdapter()
        optionsRecyclerView.layoutManager = LinearLayoutManager(this)
        optionsRecyclerView.adapter = optionsRecyclerViewAdapter
        optionsRecyclerViewAdapter.submitList(options)
        optionsRecyclerViewAdapter.onSwitchCheck = {
            handleSwitchCheck(it)
        }
    }

    private fun handleSwitchCheck(isChecked: Boolean) {
        if (isChecked) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    private fun setOptions() {
        options =
            listOf(
                Option(title = "Edit Profile", type = Type.NORMAL, icon = R.drawable.ic_person),
                Option(title = "Address", type = Type.NORMAL, icon = R.drawable.ic_address),
                Option(title = "Notification", type = Type.NORMAL, icon = R.drawable.ic_notification),
                Option(title = "Payment", type = Type.NORMAL, icon = R.drawable.ic_payment),
                Option(title = "Security", type = Type.NORMAL, icon = R.drawable.ic_security),
                Option(title = "Language", type = Type.LANGUAGE, icon = R.drawable.ic_language),
                Option(title = "Dark Mode", type = Type.DARK_MODE, icon = R.drawable.ic_eye),
                Option(title = "Privacy Policy", type = Type.NORMAL, icon = R.drawable.ic_lock),
                Option(title = "Help Center", type = Type.NORMAL, icon = R.drawable.ic_help),
                Option(title = "Invite Friends", type = Type.NORMAL, icon = R.drawable.ic_friends),
                Option(title = "Logout", type = Type.EXIT, icon = R.drawable.ic_logout)
            )
    }
}