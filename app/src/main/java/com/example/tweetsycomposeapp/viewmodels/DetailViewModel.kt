package com.example.tweetsycomposeapp.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetsycomposeapp.models.TweetsDataModelItem
import com.example.tweetsycomposeapp.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: TweetRepository, private val savedStateHandle: SavedStateHandle) : ViewModel() {

    val tweets : StateFlow<List<TweetsDataModelItem>>

        get() = repository.tweets

    init {
        viewModelScope.launch {
            val category = savedStateHandle.get<String>("category") ?: "Android"
            repository.getTweet(category)
        }
    }

}