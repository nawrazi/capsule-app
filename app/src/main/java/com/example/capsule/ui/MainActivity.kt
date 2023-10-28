package com.example.capsule.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.viewModels
import com.example.capsule.R
import com.example.capsule.databinding.ActivityMainBinding
import com.example.capsule.ui.tabs.adapter.MainActivityTabAdapter
import com.example.capsule.ui.tabs.adapter.ViewPagerSwitcher
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity(), ViewPagerSwitcher {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        LessonCountDownTimer(70000, 1000).start()
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

    override fun switchToTab(tabIndex: Int) {
        binding.viewPager.currentItem = tabIndex
    }

    inner class LessonCountDownTimer(millisInFuture: Long, countDownInterval: Long) :
        CountDownTimer(millisInFuture, countDownInterval) {

        override fun onTick(millisUntilFinished: Long) {
            val secondsRemaining = millisUntilFinished / 1000
            binding.timer.text = getString(
                R.string.timer,
                (secondsRemaining / 60).toInt(),
                String.format("%02d", secondsRemaining % 60)
            )
        }

        override fun onFinish() {
            Snackbar
                .make(
                    this@MainActivity,
                    binding.root,
                    getString(R.string.times_up),
                    Snackbar.LENGTH_LONG
                )
                .show()
        }
    }

}