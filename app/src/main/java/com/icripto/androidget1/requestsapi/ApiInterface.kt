package com.icripto.androidget1.requestsapi

import com.icripto.androidget1.modelsrequests.PostListItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("posts")
    fun getData(): Call<List<PostListItem>>
    @GET("posts")
    fun getDataByUser(@Query("userId") userId: Int,
                      @Query("id") id: Int): Call<List<PostListItem>>
}