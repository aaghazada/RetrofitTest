package com.example.api.data.model.remote

import com.example.api.data.model.remote.AddressResponseModel
import com.example.api.data.model.remote.CompanyResponseModel

data class UserModel(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: AddressResponseModel,
    val phone: String,
    val website: String,
    val company : CompanyResponseModel
)