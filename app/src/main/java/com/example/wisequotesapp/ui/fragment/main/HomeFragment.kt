package com.example.wisequotesapp.ui.fragment.main

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wisequotesapp.R
import com.example.wisequotesapp.databinding.FragmentHomeBinding
import com.example.wisequotesapp.ui.activity.MainActivity
import com.example.wisequotesapp.ui.adapter.FavoritesAdapter
import com.example.wisequotesapp.ui.model.Author

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var list: List<Author>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        (activity as MainActivity).supportActionBar?.title = "Wise Quotes"
        
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.main_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.favorites -> {
                        findNavController().navigate(R.id.action_navigation_home_to_navigation_fav)
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

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
        binding.rvHome.layoutManager = LinearLayoutManager(requireActivity())
        binding.rvHome.adapter = FavoritesAdapter(this@HomeFragment, list)
    }

}