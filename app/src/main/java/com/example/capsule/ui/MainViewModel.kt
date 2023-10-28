package com.example.capsule.ui

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.capsule.domain.model.DummyData

class MainViewModel : ViewModel() {
    val lesson = DummyData.lesson
    private val userAnswers: MutableList<Int?> = lesson.quiz.questions.map { null }.toMutableList()
    private var currentQuestion = MutableLiveData(0)
    var currentQuestionText = MediatorLiveData<String>().apply {
        addSource(currentQuestion) {
            value = lesson.quiz.questions[it].question
        }
    }

    fun isLastQuestion(): Boolean {
        return currentQuestion.value == lesson.quiz.questions.size - 1
    }

    fun getOptionsList(): List<String> {
        return lesson.quiz.questions[currentQuestion.value!!].options
    }

    fun isAnswerSelected(answer: Int): Boolean {
        return userAnswers[currentQuestion.value!!] == answer
    }

    fun answerQuestion(answer: Int) {
        userAnswers[currentQuestion.value!!] = answer
    }

    fun nextQuestion() {
        if (currentQuestion.value!! < lesson.quiz.questions.size - 1) {
            currentQuestion.value = currentQuestion.value!! + 1
        }
    }

    fun isCurrentQuestionAnswered(): Boolean {
        return userAnswers[currentQuestion.value!!] != null
    }

    fun getCorrectAnswers(): Int {
        return userAnswers.filterIndexed { index, answer ->
            answer == lesson.quiz.questions[index].answerIndex
        }.size
    }

    fun getTotalQuestions(): Int {
        return lesson.quiz.questions.size
    }
}