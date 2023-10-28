package com.example.capsule.ui.tabs

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainActivityTabAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> VideoFragment()
            1 -> TextFragment()
            2 -> QuizFragment()
            else -> ResultFragment()
        }
}