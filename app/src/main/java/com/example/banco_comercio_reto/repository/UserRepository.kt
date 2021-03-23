package com.example.banco_comercio_reto.repository

import com.example.banco_comercio_reto.model.User
import com.example.banco_comercio_reto.api.RestApiAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    fun getUsers(onResult: (isSuccess: Boolean, response: List<User>?) -> Unit) {
        RestApiAdapter.INSTANCE.getUser().enqueue(object: Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>?, response: Response<List<User>>) {
                if (response.isSuccessful)
                    onResult(true, response.body()!!)
                else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<List<User>>?, t: Throwable?) {
                onResult(false, null)
            }
        })
    }

    companion object {
        private var INSTANCE: UserRepository? = null
        fun getInstance() = INSTANCE
            ?: UserRepository().also {
                INSTANCE = it
            }
    }
}