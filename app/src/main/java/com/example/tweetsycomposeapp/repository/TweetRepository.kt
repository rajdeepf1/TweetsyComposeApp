package com.example.tweetsycomposeapp.repository

import com.example.tweetsycomposeapp.api.TweetsyApi
import com.example.tweetsycomposeapp.models.TweetsDataModelItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetRepository @Inject constructor(private val tweetsyApi: TweetsyApi) {

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>>
        get() = _categories

    private val _tweets = MutableStateFlow<List<TweetsDataModelItem>>(emptyList())
    val tweets: StateFlow<List<TweetsDataModelItem>>
        get() = _tweets

    suspend fun getCategories(){
        val response = tweetsyApi.getCategories()
        if (response.isSuccessful && response.body() != null){
            _categories.emit(response.body()!!)
        }
    }

    suspend fun getTweet(category: String){
        val response = tweetsyApi.getTweets(category)
        if (response.isSuccessful && response.body() != null){
            _tweets.emit(response.body()!!)
        }
    }

}