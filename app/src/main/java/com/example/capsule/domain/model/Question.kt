package com.example.capsule.domain.model

data class Question(
    val id: String,
    val question: String,
    val options: List<String>,
    val answerIndex: Int,
)