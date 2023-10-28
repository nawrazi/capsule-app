package com.example.capsule.domain.model

data class Lesson(
    val id: String,
    val title: String,
    val notes: String,
    val videoUrl: String,
    val quiz: Quiz,
)
