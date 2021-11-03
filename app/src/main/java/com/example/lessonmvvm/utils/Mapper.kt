package com.example.lessonmvvm.utils

interface Mapper<in Input,out Output>{
    fun map(input: Input) : Output
    fun mapToList(list : List<Input>) : List<Output>
}