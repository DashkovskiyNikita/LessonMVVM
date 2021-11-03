package com.example.lessonmvvm.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BlogDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBlog(blogCacheEntity: BlogCacheEntity)

    @Query("SELECT * FROM ${BlogCacheEntity.TABLE_NAME}")
    suspend fun getBlogs() : List<BlogCacheEntity>

}