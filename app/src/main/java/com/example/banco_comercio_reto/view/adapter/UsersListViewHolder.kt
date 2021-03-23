package com.example.banco_comercio_reto.view.adapter

import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.databinding.ViewDataBinding
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.banco_comercio_reto.BR
import com.example.banco_comercio_reto.R
import com.example.banco_comercio_reto.model.User
import com.example.banco_comercio_reto.viewmodel.UsersListViewModel

class UsersListViewHolder constructor(private val dataBinding: ViewDataBinding, private val usersListViewModel: UsersListViewModel)
    : RecyclerView.ViewHolder(dataBinding.root) {
    private val firstLetterName: TextView = itemView.findViewById(R.id.firstLetterNameTextView)

    fun setup(user: User) {
        dataBinding.setVariable(BR.user, user)
        dataBinding.executePendingBindings()

        firstLetterName.text = user.name.substring(0, 1)

        itemView.setOnClickListener {
            val bundle = bundleOf(
                "id" to user.id,
                "name" to user.name,
                "username" to user.username,
                "email" to user.email,
                "phone" to user.phone,
                "webSite" to user.webSite,
                "street" to user.address.street,
                "suite" to user.address.suite,
                "city" to user.address.city,
                "companyName" to user.company.name,
                "catchPhrase" to user.company.catchPhrase
            )

            itemView.findNavController().navigate(R.id.action_MainFragment_to_UserDetailFragment, bundle)
        }
    }
}