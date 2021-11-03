package com.example.lessonmvvm.retrofit

import com.example.lessonmvvm.room.BlogCacheEntity
import com.example.lessonmvvm.utils.Mapper
import javax.inject.Inject

class NetworkMapper @Inject constructor() : Mapper<BlogNetworkEntity,BlogCacheEntity> {

    override fun map(input: BlogNetworkEntity): BlogCacheEntity {
        return BlogCacheEntity(
            id = input.id,
            title = input.title,
            body = input.body,
            image = input.image,
            category = input.category
        )
    }

    override fun mapToList(list: List<BlogNetworkEntity>): List<BlogCacheEntity> {
        return list.map { input -> map(input) }
    }


}