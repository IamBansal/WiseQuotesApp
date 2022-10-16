package com.example.wisequotesapp.ui.fragment.main

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import com.example.wisequotesapp.R
import com.example.wisequotesapp.databinding.FragmentNotificationBinding
import com.example.wisequotesapp.ui.activity.MainActivity

class NotificationFragment : Fragment() {

    private lateinit var binding: FragmentNotificationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNotificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.notifications_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.fav -> {
                        Toast.makeText(requireActivity(), "Fav CLicked.", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.check -> {
                        Toast.makeText(requireActivity(), "Check CLicked.", Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        setupToolbar()

    }

    private fun setupToolbar() {
        (activity as MainActivity?)!!.supportActionBar!!.title = "Notifications"
        (activity as MainActivity?)!!.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

}