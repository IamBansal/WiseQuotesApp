package com.example.wisequotesapp.ui.fragment.auth

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.wisequotesapp.databinding.CustomBottomSheetBinding
import com.example.wisequotesapp.databinding.FragmentSignupBinding
import com.google.android.material.bottomsheet.BottomSheetDialog


class SignupFragment : Fragment() {

    private lateinit var binding: FragmentSignupBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvToLogin.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.signupButton.setOnClickListener {
            showBottomSheetDialog()
        }

    }

    private fun showBottomSheetDialog() {
        val dialog = BottomSheetDialog(requireActivity())
        val view = CustomBottomSheetBinding.inflate(layoutInflater)

        view.numberOTP.text = binding.etPhone.text

        dialog.setCancelable(true)
        dialog.setContentView(view.root)
        dialog.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
        view.submitOTP.setOnClickListener {
            dialog.dismiss()
        }

        object : CountDownTimer(31000, 1000) {
            @SuppressLint("SetTextI18n")
            override fun onTick(millisUntilFinished: Long) {
                view.timer.text = "00:${millisUntilFinished / 1000}"
            }

            override fun onFinish() {
                dialog.dismiss()
            }
        }.start()

        dialog.show()
    }

}