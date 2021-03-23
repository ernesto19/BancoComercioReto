package com.example.banco_comercio_reto.model

import com.google.gson.annotations.SerializedName

data class Address (
    val street: String,
    val suite: String,
    val city: String,
    @SerializedName("zipcode") val zipCode: String
)