package com.example.capsule.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.capsule.R
import com.example.capsule.databinding.ActivityMainBinding
import com.example.capsule.ui.tabs.MainActivityTabAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.title = viewModel.lesson.title
        setupTabLayout()
    }

    private fun setupTabLayout() {
        val viewPager = binding.viewPager.apply {
            adapter = MainActivityTabAdapter(this@MainActivity)
        }

        TabLayoutMediator(binding.tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.video_tab)
                1 -> getString(R.string.text_tab)
                2 -> getString(R.string.quiz_tab)
                else -> getString(R.string.result_tab)
            }
        }.attach()
    }
}