package com.example.capsule.ui

import androidx.lifecycle.ViewModel
import com.example.capsule.domain.model.DummyData

class MainActivityViewModel : ViewModel() {
    val lesson = DummyData.lesson
}