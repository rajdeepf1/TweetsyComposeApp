package com.example.tweetsycomposeapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetsycomposeapp.models.TweetsDataModelItem
import com.example.tweetsycomposeapp.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: TweetRepository) : ViewModel() {

    val tweets : StateFlow<List<TweetsDataModelItem>>

        get() = repository.tweets

    init {
        viewModelScope.launch {
            repository.getTweet("Android")
        }
    }

}