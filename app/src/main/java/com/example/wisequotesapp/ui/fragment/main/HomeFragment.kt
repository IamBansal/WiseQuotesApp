package com.example.wisequotesapp.ui.fragment.main

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.example.wisequotesapp.R
import com.example.wisequotesapp.databinding.FragmentHomeBinding
import com.example.wisequotesapp.ui.activity.MainActivity

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

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
                    R.id.notification -> {
                        findNavController().navigate(R.id.action_navigation_home_to_navigation_notifications)
                        true
                    }
                    R.id.profile -> {
                        findNavController().navigate(R.id.action_navigation_home_to_navigation_profile)
                        true
                    }
                    R.id.favorites -> {
                        findNavController().navigate(R.id.action_navigation_home_to_navigation_fav)
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

    }

}