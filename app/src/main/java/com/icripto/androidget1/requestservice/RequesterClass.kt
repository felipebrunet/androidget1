package com.icripto.androidget1.requestservice

import android.util.Log
import android.widget.TextView
import com.icripto.androidget1.BASE_URL
import com.icripto.androidget1.modelsrequests.PostListItem
import com.icripto.androidget1.requestsapi.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RequesterClass (textView: TextView, selectedUser: Int, postId : Int) {
    val textview = textView
    private val userId = selectedUser
    private val id = postId


    fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()
        retrofitData.enqueue(object : Callback<List<PostListItem>?> {
            override fun onResponse(
                call: Call<List<PostListItem>?>,
                response: Response<List<PostListItem>?>
            ) {
                val responseBody = response.body()!!

                val myStringBuilder = StringBuilder()
                for (myData in responseBody) {
                    myStringBuilder.append(myData.id)
                    myStringBuilder.append("\n")
                }
                val textView1 = textview
                textView1.text = myStringBuilder
            }
            override fun onFailure(call: Call<List<PostListItem>?>, t: Throwable) {
                Log.d("MainActivitydebug", "onFailure: "+t.message)
            }
        })
    }

    fun getDataByUser() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getDataByUser(userId, id = id)
        retrofitData.enqueue(object : Callback<List<PostListItem>?> {
            override fun onResponse(
                call: Call<List<PostListItem>?>,
                response: Response<List<PostListItem>?>
            ) {
                val responseBody = response.body()!!

                val myStringBuilder = StringBuilder()
                for (myData in responseBody) {
                    myStringBuilder.append(myData.title)
                    myStringBuilder.append("\n")
                }
                val textView1 = textview
                textView1.text = myStringBuilder
            }
            override fun onFailure(call: Call<List<PostListItem>?>, t: Throwable) {
                Log.d("MainActivitydebug", "onFailure: "+t.message)
            }
        })
    }
}