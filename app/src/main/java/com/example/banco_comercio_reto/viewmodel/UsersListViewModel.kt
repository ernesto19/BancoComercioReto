package com.example.banco_comercio_reto.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.banco_comercio_reto.model.User
import com.example.banco_comercio_reto.repository.UserRepository

class UsersListViewModel : BaseViewModel() {
    val usersListLiveData = MutableLiveData<List<User>>()

    fun fetchUsers () {
        dataLoading.value = true

        UserRepository.getInstance().getUsers { isSuccess, response ->
            dataLoading.value = false
            if (isSuccess) {
                usersListLiveData.value = response?.toList()
                empty.value = false
            } else {
                empty.value = true
            }
        }
    }
}