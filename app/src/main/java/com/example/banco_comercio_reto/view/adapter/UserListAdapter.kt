package com.example.banco_comercio_reto.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.banco_comercio_reto.databinding.UserItemBinding
import com.example.banco_comercio_reto.model.User
import com.example.banco_comercio_reto.viewmodel.UsersListViewModel

class UserListAdapter(private val usersListViewModel: UsersListViewModel) : RecyclerView.Adapter<UsersListViewHolder>() {
    var users: List<User> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = UserItemBinding.inflate(inflater, parent, false)

        return UsersListViewHolder(dataBinding, usersListViewModel)
    }

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: UsersListViewHolder, position: Int) {
        holder.setup(users[position])
    }

    fun updateUsersList(users: List<User>) {
        this.users = users
        notifyDataSetChanged()
    }
}