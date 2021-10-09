package com.example.retro


import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.GET

interface IWakaServer {
    @GET("https://dongagd.herokuapp.com/user/")
    fun getUserList(
        @Query("username") username:String,
        @Query("password") password:String,
        @Query("email") email:String,
        @Query("familyname") familyname:String,
        @Query("age")age:String,
        @Query("dateofbirth") dateofbirth:String
    ): Call<List>

}