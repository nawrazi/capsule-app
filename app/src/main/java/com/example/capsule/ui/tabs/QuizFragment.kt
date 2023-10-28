package com.example.capsule.ui.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.capsule.databinding.FragmentQuizBinding
import com.example.capsule.ui.MainViewModel
import com.example.capsule.ui.tabs.adapter.QuizAdapter
import com.example.capsule.ui.tabs.adapter.QuizAdapterListener
import com.example.capsule.ui.tabs.adapter.ViewPagerSwitcher

class QuizFragment : Fragment(), QuizAdapterListener {
    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: QuizAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuizBinding.inflate(inflater, container, false)

        setupAdapter()
        binding.apply {
            vm = viewModel
            lifecycleOwner = viewLifecycleOwner
            nextButton.setOnClickListener {
                if (!viewModel.isCurrentQuestionAnswered()) return@setOnClickListener

                if (!viewModel.isLastQuestion()) {
                    viewModel.nextQuestion()
                    setAdapterItems()
                    return@setOnClickListener
                }

                val activity = requireActivity()
                if (activity is ViewPagerSwitcher) {
                    activity.switchToTab(3)
                }
            }
        }

        return binding.root
    }

    private fun setupAdapter() {
        adapter = QuizAdapter(this)
        binding.answerList.adapter = adapter
        binding.answerList.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
            context, androidx.recyclerview.widget.LinearLayoutManager.VERTICAL, false
        )
        setAdapterItems()
    }

    private fun setAdapterItems() {
        adapter.setItems(viewModel.getOptionsList())
    }

    override fun isAnswerSelected(answer: Int): Boolean {
        return viewModel.isAnswerSelected(answer)
    }

    override fun onAnswerSelected(answer: Int) {
        viewModel.answerQuestion(answer)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}