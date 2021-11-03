package com.example.lessonmvvm.utils

sealed class ScreenState {
    data class Success<out T>(val data: T) : ScreenState()
    data class Error(val exp: Exception) :ScreenState()
    object Loading : ScreenState()
}
