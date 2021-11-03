package com.example.lessonmvvm.di

import com.example.lessonmvvm.repository.MainRepository
import com.example.lessonmvvm.retrofit.BlogRetrofit
import com.example.lessonmvvm.retrofit.NetworkMapper
import com.example.lessonmvvm.room.BlogDao
import com.example.lessonmvvm.room.CacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        blogRetrofit: BlogRetrofit,
        blogDao: BlogDao,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): MainRepository {
        return MainRepository(
            blogRetrofit = blogRetrofit,
            blogDao = blogDao,
            cacheMapper = cacheMapper,
            networkMapper = networkMapper
        )
    }
}