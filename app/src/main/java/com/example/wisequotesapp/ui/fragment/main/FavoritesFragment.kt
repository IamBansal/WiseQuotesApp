package com.example.wisequotesapp.ui.fragment.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wisequotesapp.R
import com.example.wisequotesapp.ui.activity.MainActivity

class FavoritesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()

    }

    private fun setupToolbar() {
        (activity as MainActivity?)!!.supportActionBar!!.title = "Favorites"
        (activity as MainActivity?)!!.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

}