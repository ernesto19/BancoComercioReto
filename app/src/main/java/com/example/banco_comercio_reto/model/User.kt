package com.example.banco_comercio_reto.model

import com.google.gson.annotations.SerializedName

data class User (
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    @SerializedName("website") val webSite: String,
    val company: Company
)