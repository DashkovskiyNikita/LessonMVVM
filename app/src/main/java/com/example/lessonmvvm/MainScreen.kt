package com.example.lessonmvvm

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.lessonmvvm.appui.BlogViewModel
import com.example.lessonmvvm.model.BlogData
import com.example.lessonmvvm.utils.ScreenState

@Composable
fun MainScreen(
    blogViewModel: BlogViewModel
) {
    val blogState = blogViewModel.screenState.observeAsState()
    Box(modifier = Modifier.fillMaxSize()) {
        when (val state = blogState.value) {
            is ScreenState.Loading -> ProgressBar(modifier = Modifier.align(Alignment.Center))
            is ScreenState.Success<*> -> ShowList(
                Modifier.align(Alignment.TopCenter),
                state.data as List<BlogData>
            )
            is ScreenState.Error -> Log.d("MainScreen", "exception : ${state.exp}")
        }
    }
}

@Composable
fun ShowList(
    modifier: Modifier,
    blogData: List<BlogData>
) {
    LazyColumn(modifier = modifier
        .fillMaxWidth()
        .padding(10.dp)) {
        items(blogData.size) {
            Text(text = blogData[it].body, textAlign = TextAlign.Start)
            Spacer(modifier = Modifier.padding(10.dp))
        }
    }
}

@Composable
fun ProgressBar(
    modifier: Modifier,
) {
    CircularProgressIndicator(modifier = modifier)
}