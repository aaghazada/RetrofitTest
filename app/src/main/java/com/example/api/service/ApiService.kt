package com.example.api.service

import com.example.api.data.model.remote.UserModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("users")
    fun getUsers(): Call<List<UserModel>>

//    @GET("users/{userId}")
//    fun getUsersId(@Path("userId") userId: String): Call<UserModel>

}
