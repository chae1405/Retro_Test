package com.example.retro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class MainActivity : AppCompatActivity() {
    lateinit var retrofit: Retrofit
        lateinit var myApi:IWakaServer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val TAG = MainActivity::class.java.simpleName
        Log.d("Tag","on create!")
        setContentView(R.layout.activity_main)

        retrofit = RetrofitClient.getInstance()
        myApi = retrofit.create(IWakaServer::class.java)

       Runnable{myApi.getUserList("","","","","","").enqueue(object :Callback<List>{

           override fun onFailure(call: Call<List>, t: Throwable)
           {
               TODO("Not yet implemented")
              // Log.d(TAG,t.message)
           }

           override fun onResponse(call: Call<List>, response: Response<List>) {
               TODO("Not yet implemented")
               Log.d(TAG,"response : ${response.body()!!.username}")
               Log.d(TAG,"response : ${response.errorBody()}")
               Log.d(TAG,"response : ${response.message()}")
               Log.d(TAG,"response : ${response.code()}")
           }


       })


       }.run()
    }
}