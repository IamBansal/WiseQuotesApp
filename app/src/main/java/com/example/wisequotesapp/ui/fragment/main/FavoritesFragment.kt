package com.example.wisequotesapp.ui.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wisequotesapp.databinding.FragmentFavoritesBinding
import com.example.wisequotesapp.ui.activity.MainActivity
import com.example.wisequotesapp.ui.adapter.FavoritesAdapter
import com.example.wisequotesapp.ui.model.Author

class FavoritesFragment : Fragment() {

    private lateinit var binding: FragmentFavoritesBinding
    private lateinit var list: List<Author>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()

        list = listOf(
            Author("Notification 1"),
            Author("Notification 2"),
            Author("Notification 3"),
            Author("Notification 4"),
            Author("Notification 5"),
            Author("Notification 5"),
            Author("Notification 5"),
            Author("Notification 5"),
            Author("Notification 5"),
            Author("Notification 10"),
        )
        binding.rvFav.layoutManager = LinearLayoutManager(requireActivity())
        binding.rvFav.adapter = FavoritesAdapter(this@FavoritesFragment, list)

    }

    private fun setupToolbar() {
        (activity as MainActivity?)!!.supportActionBar!!.title = "Favorites"
        (activity as MainActivity?)!!.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

}