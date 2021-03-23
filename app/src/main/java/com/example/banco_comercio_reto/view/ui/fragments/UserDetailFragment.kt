package com.example.banco_comercio_reto.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.banco_comercio_reto.R
import kotlinx.android.synthetic.main.user_detail_fragment.*
import kotlinx.android.synthetic.main.user_detail_fragment.emailTextView

class UserDetailFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.user_detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            (activity as? AppCompatActivity)?.supportActionBar?.title = UserDetailFragmentArgs.fromBundle(it).name

            emailTextView.text      = UserDetailFragmentArgs.fromBundle(it).email
            phoneTextView.text      = UserDetailFragmentArgs.fromBundle(it).phone
            webSiteTextView.text    = UserDetailFragmentArgs.fromBundle(it).webSite
            streetTextView.text     = UserDetailFragmentArgs.fromBundle(it).street
            suiteTextView.text      = UserDetailFragmentArgs.fromBundle(it).suite
            cityTextView.text       = UserDetailFragmentArgs.fromBundle(it).city
            companyNameTextView.text = UserDetailFragmentArgs.fromBundle(it).companyName
            catchPhraseTextView.text = UserDetailFragmentArgs.fromBundle(it).catchPhrase
        }
    }
}