package com.example.capsule.ui.tabs.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.capsule.databinding.ItemQuizAnswerBinding

class QuizAdapter(
    private val listener: QuizAdapterListener
) : RecyclerView.Adapter<QuizAdapter.ViewHolder>() {

    private var _allItems: List<String> = listOf()

    inner class ViewHolder(binding: ItemQuizAnswerBinding) :
        RecyclerView.ViewHolder(binding.root) {
            val check = binding.checkIcon
            val answer = binding.answerText
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemQuizAnswerBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.answer.text = _allItems[position]
        holder.check.visibility = if (listener.isAnswerSelected(position)) {
            ViewGroup.VISIBLE
        } else {
            ViewGroup.INVISIBLE
        }
        holder.itemView.setOnClickListener {
            listener.onAnswerSelected(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return _allItems.size
    }

    fun setItems(items: List<String>) {
        _allItems = items
        notifyDataSetChanged()
    }
}

interface QuizAdapterListener {
    fun onAnswerSelected(answer: Int)
    fun isAnswerSelected(answer: Int): Boolean
}