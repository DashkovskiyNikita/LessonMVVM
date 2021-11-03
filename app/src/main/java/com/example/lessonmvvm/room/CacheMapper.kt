package com.example.lessonmvvm.room

import com.example.lessonmvvm.model.BlogData
import com.example.lessonmvvm.utils.Mapper
import javax.inject.Inject

class CacheMapper @Inject constructor() : Mapper<BlogCacheEntity, BlogData> {
    override fun map(input: BlogCacheEntity): BlogData {
        return BlogData(
            id = input.id,
            title = input.title,
            body = input.body
        )
    }

    override fun mapToList(list: List<BlogCacheEntity>): List<BlogData> {
        return list.map { input -> map(input) }
    }


}