package com.example.wisequotesapp.ui.fragment.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.wisequotesapp.R
import com.example.wisequotesapp.databinding.FragmentProfileBinding
import com.example.wisequotesapp.ui.activity.MainActivity

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(requireActivity()).load(R.drawable.model).circleCrop().into(binding.imageProfile)

        setupToolbar()

        binding.editProfile.setOnClickListener {
            Toast.makeText(requireActivity(), "Edit Profile is accessed.", Toast.LENGTH_SHORT).show()
        }

        binding.changePass.setOnClickListener {
            Toast.makeText(requireActivity(), "Change Password is accessed.", Toast.LENGTH_SHORT).show()
        }

    }

    private fun setupToolbar() {
        (activity as MainActivity?)!!.supportActionBar!!.title = "Your Profile"
        (activity as MainActivity?)!!.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

}