package com.example.banco_comercio_reto.api

import com.example.banco_comercio_reto.model.User
import retrofit2.Call
import retrofit2.http.GET

interface Service {
    @GET("users")
    fun getUser(): Call<List<User>>
}