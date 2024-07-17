package com.example.tweetsycomposeapp.api

import com.example.tweetsycomposeapp.models.TweetsDataModelItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsyApi {

    @GET("/v3/b/669744b9acd3cb34a86739f4?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String): Response<List<TweetsDataModelItem>>

    @GET("/v3/b/669744b9acd3cb34a86739f4?meta=false")
    @Headers("X-JSON-Path:tweets..category")
    suspend fun getCategories():Response<List<String>>
}