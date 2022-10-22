package com.example.wisequotesapp.ui.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wisequotesapp.databinding.FragmentRecentBinding
import com.example.wisequotesapp.ui.activity.MainActivity
import com.example.wisequotesapp.ui.adapter.FavoritesAdapter
import com.example.wisequotesapp.ui.model.Author

class RecentFragment : Fragment() {

    private lateinit var binding: FragmentRecentBinding
    private lateinit var list: List<Author>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecentBinding.inflate(inflater, container, false)
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
        binding.rvRecent.layoutManager = LinearLayoutManager(requireActivity())
        binding.rvRecent.adapter = FavoritesAdapter(this@RecentFragment, list)

    }

    private fun setupToolbar() {
        (activity as MainActivity?)!!.supportActionBar!!.title = "Recent"
        (activity as MainActivity?)!!.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}