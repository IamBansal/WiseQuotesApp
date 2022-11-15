package com.example.wisequotesapp.ui.fragment.auth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.wisequotesapp.R
import com.example.wisequotesapp.databinding.FragmentLoginBinding
import com.example.wisequotesapp.ui.activity.AuthActivity
import com.example.wisequotesapp.ui.activity.SelectActivity

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvToSignup.setOnClickListener {
            findNavController().navigate(
                R.id.action_navigation_login_to_navigation_signup, null,
                navOptions {
                    anim {
                        enter = android.R.animator.fade_in
                        exit = android.R.animator.fade_out
                    }
                })
        }

        binding.loginButton.setOnClickListener {
            startActivity(Intent(requireActivity(), SelectActivity::class.java))
            (activity as AuthActivity).finishAffinity()
        }

    }

}