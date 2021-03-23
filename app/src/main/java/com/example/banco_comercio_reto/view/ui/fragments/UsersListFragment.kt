package com.example.banco_comercio_reto.view.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.banco_comercio_reto.databinding.UsersListFragmentBinding
import com.example.banco_comercio_reto.view.adapter.UserListAdapter
import com.example.banco_comercio_reto.viewmodel.UsersListViewModel
import kotlinx.android.synthetic.main.users_list_fragment.*

class UsersListFragment : Fragment() {

    private lateinit var viewDataBinding: UsersListFragmentBinding
    private lateinit var adapter: UserListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = UsersListFragmentBinding.inflate(inflater, container, false).apply {
            viewModel = ViewModelProvider(this@UsersListFragment).get(UsersListViewModel::class.java)
            lifecycleOwner = viewLifecycleOwner
        }

        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.viewModel?.fetchUsers()

        setupAdapter()
        setupObservers()
    }

    private fun setupObservers() {
        viewDataBinding.viewModel?.usersListLiveData?.observe(viewLifecycleOwner, Observer {
            adapter.updateUsersList(it)
        })
    }

    private fun setupAdapter() {
        val viewModel = viewDataBinding.viewModel
        if (viewModel != null) {
            adapter = UserListAdapter(viewDataBinding.viewModel!!)
            val layoutManager = LinearLayoutManager(activity)
            userRecyclerView.layoutManager = layoutManager
            userRecyclerView.adapter = adapter
        }
    }
}