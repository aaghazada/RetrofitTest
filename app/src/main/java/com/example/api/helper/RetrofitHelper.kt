package com.example.api.helper

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private val retrofitHelper: Retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/users/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val apiService: ApiService = retrofitHelper.create(ApiService::class.java)
}
