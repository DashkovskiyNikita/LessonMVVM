package com.example.lessonmvvm.repository

import com.example.lessonmvvm.model.BlogData
import com.example.lessonmvvm.retrofit.BlogRetrofit
import com.example.lessonmvvm.retrofit.NetworkMapper
import com.example.lessonmvvm.room.BlogDao
import com.example.lessonmvvm.room.CacheMapper
import com.example.lessonmvvm.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepository(
    val blogRetrofit: BlogRetrofit,
    val blogDao: BlogDao,
    val cacheMapper: CacheMapper,
    val networkMapper: NetworkMapper
) : Repository {
    override fun fetchBlogs(): Flow<Result<List<BlogData>>>  = flow {
        try {
            val networkBlogs = blogRetrofit.fetchBlogs()
            val mappedEntities= networkMapper.mapToList(networkBlogs)
            mappedEntities.forEach { entity ->
                blogDao.insertBlog(entity)
            }
            val entities = blogDao.getBlogs()
            val blogData = cacheMapper.mapToList(entities)
            emit(Result.Success(blogData))
        }catch (exp : Exception){
            emit(Result.Error(exp))
        }
    }


}
