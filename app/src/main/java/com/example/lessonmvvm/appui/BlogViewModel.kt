package com.example.lessonmvvm.appui


import androidx.lifecycle.*
import com.example.lessonmvvm.model.BlogData
import com.example.lessonmvvm.repository.MainRepository
import com.example.lessonmvvm.utils.Result
import com.example.lessonmvvm.utils.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class BlogViewModel
@Inject constructor(
    private val mainRepository: MainRepository,
) : ViewModel() {
    private val _screenState = MutableLiveData<ScreenState>(ScreenState.Loading)
    val screenState: LiveData<ScreenState>
        get() = _screenState

    fun dataState(){
        viewModelScope.launch {
            mainRepository.fetchBlogs().onEach {  result ->
                when(result){
                    is Result.Success ->{
                        _screenState.value = ScreenState.Success(result.data)
                    }
                    is Result.Error ->{
                        _screenState.value = ScreenState.Error(result.exp)
                    }
                }
            }.launchIn(viewModelScope)
        }

    }
}