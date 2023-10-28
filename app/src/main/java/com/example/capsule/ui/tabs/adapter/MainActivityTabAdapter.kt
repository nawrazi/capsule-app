package com.example.capsule.ui.tabs.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.capsule.ui.tabs.QuizFragment
import com.example.capsule.ui.tabs.ResultFragment
import com.example.capsule.ui.tabs.TextFragment
import com.example.capsule.ui.tabs.VideoFragment

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