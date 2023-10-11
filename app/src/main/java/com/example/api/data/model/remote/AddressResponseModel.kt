package com.example.api.data.model.remote

data class AddressResponseModel(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo : GeoResponseModel
)