package com.example.api.helper

import com.example.api.data.model.UserModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/users")
    fun getUsers(): Call<List<UserModel>>
}
