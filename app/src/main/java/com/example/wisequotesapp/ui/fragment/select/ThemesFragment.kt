package com.example.wisequotesapp.ui.fragment.select

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.wisequotesapp.databinding.FragmentThemesBinding
import com.example.wisequotesapp.ui.activity.MainActivity
import com.example.wisequotesapp.ui.activity.SelectActivity
import com.example.wisequotesapp.ui.adapter.ThemeAdapter
import com.example.wisequotesapp.ui.model.Author

class ThemesFragment : Fragment() {

    private lateinit var binding: FragmentThemesBinding
    private lateinit var list: List<Author>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThemesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list = listOf(
            Author("Theme 1"),
            Author("Theme 2"),
            Author("Theme 3"),
            Author("Theme 4"),
            Author("Theme 5"),
        )
        binding.rvList.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL)
        binding.rvList.adapter = ThemeAdapter(this@ThemesFragment, list)

        binding.select.setOnClickListener {
            startActivity(Intent(requireActivity(), MainActivity::class.java))
            (activity as SelectActivity).finishAffinity()
        }

        setupToolbar()

    }

    private fun setupToolbar() {
        (activity as SelectActivity?)!!.supportActionBar!!.title = "Themes"
        (activity as SelectActivity?)!!.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}