package com.example.wisequotesapp.ui.fragment.select

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.wisequotesapp.R
import com.example.wisequotesapp.databinding.FragmentAuthorsBinding
import com.example.wisequotesapp.ui.activity.SelectActivity
import com.example.wisequotesapp.ui.adapter.AuthorsAdapter
import com.example.wisequotesapp.ui.model.Author

class AuthorsFragment : Fragment() {

    private lateinit var binding: FragmentAuthorsBinding
    private lateinit var list: List<Author>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
            binding = FragmentAuthorsBinding.inflate(inflater, container, false)
            return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list = listOf(
           Author("Author 1"),
           Author("Author 2"),
           Author("Author 3"),
           Author("Author 4"),
           Author("Author 5"),
           Author("Author 5"),
           Author("Author 5"),
           Author("Author 5"),
           Author("Author 5"),
           Author("Author 5"),
        )
        binding.rvList.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        binding.rvList.adapter = AuthorsAdapter(this@AuthorsFragment, list)

        binding.select.setOnClickListener {
            findNavController().navigate(
                R.id.action_navigation_author_to_navigation_theme, null,
                navOptions {
                    anim {
                        enter = android.R.animator.fade_in
                        exit = android.R.animator.fade_out
                    }
                })
        }
        setupToolbar()

    }

    private fun setupToolbar() {
        (activity as SelectActivity?)!!.supportActionBar!!.title = "Authors"
        (activity as SelectActivity?)!!.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

}