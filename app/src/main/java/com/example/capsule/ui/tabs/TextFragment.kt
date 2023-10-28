package com.example.capsule.ui.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.capsule.R
import com.example.capsule.databinding.FragmentTextBinding
import com.example.capsule.ui.MainViewModel
import com.example.capsule.ui.tabs.adapter.ViewPagerSwitcher

class TextFragment : Fragment() {
    private var _binding: FragmentTextBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTextBinding.inflate(inflater, container, false)

        binding.notesText.text = viewModel.lesson.notes
        binding.nextTextBot.text = getString(
            R.string.quiz_questions_preview,
            viewModel.getTotalQuestions()
        )

        binding.nextPageButton.setOnClickListener {
            val activity = requireActivity()
            if (activity is ViewPagerSwitcher) {
                activity.switchToTab(2)
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}