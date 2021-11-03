package com.example.lessonmvvm.utils

sealed class Result<out T>{
    data class Success<out T>(val data : T) : Result<T>()
    data class Error(val exp : Exception) : Result<Nothing>()
}
