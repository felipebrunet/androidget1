package com.icripto.androidget1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.icripto.androidget1.requestservice.RequesterClass
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


const val BASE_URL = "https://jsonplaceholder.typicode.com/"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userId = 3
        val id = 21
        val textview1 = findViewById<TextView>(R.id.text1)
        val requester = RequesterClass(textView = textview1, userId, id)

//        requester.getMyData()
        requester.getDataByUser()



    }

}