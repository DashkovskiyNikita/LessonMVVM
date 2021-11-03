package com.example.lessonmvvm.repository

import com.example.lessonmvvm.model.BlogData
import com.example.lessonmvvm.utils.Result
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun fetchBlogs() : Flow<Result<List<BlogData>>>
}