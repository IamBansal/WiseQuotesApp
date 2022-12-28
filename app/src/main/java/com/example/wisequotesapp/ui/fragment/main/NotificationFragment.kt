package com.example.wisequotesapp.ui.fragment.main

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wisequotesapp.R
import com.example.wisequotesapp.databinding.FragmentNotificationBinding
import com.example.wisequotesapp.ui.activity.MainActivity
import com.example.wisequotesapp.ui.adapter.NotificationsAdapter
import com.example.wisequotesapp.ui.model.Author

class NotificationFragment : Fragment() {

    private lateinit var binding: FragmentNotificationBinding
    private lateinit var list: List<Author>

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
                    R.id.check -> {
                        findNavController().navigate(
                            R.id.action_navigation_notifications_to_navigation_quote_theme)
                        Toast.makeText(requireActivity(), "Mark all as read function.\nShowing quote theme fragment here.", Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

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
        binding.rvNotifications.layoutManager = LinearLayoutManager(requireActivity())
        binding.rvNotifications.adapter = NotificationsAdapter(this@NotificationFragment, list)

    }

    private fun setupToolbar() {
        (activity as MainActivity?)!!.supportActionBar!!.title = "Notifications"
        (activity as MainActivity?)!!.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

}