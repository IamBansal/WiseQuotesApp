package com.example.wisequotesapp.ui.fragment.select

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.wisequotesapp.R
import com.example.wisequotesapp.databinding.FragmentCategoriesBinding
import com.example.wisequotesapp.ui.adapter.AuthorsAdapter
import com.example.wisequotesapp.ui.model.Author

class CategoriesFragment : Fragment() {

    private lateinit var binding: FragmentCategoriesBinding
    private lateinit var list: List<Author>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoriesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list = listOf(
            Author("Category 1"),
            Author("Category 2"),
            Author("Category 3"),
            Author("Category 4"),
            Author("Category 5"),
            Author("Category 5"),
            Author("Category 5"),
            Author("Category 5"),
            Author("Category 5"),
            Author("Category 5"),
        )
        binding.rvList.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        binding.rvList.adapter = AuthorsAdapter(this@CategoriesFragment, list)

        binding.select.setOnClickListener {
            findNavController().navigate(
                R.id.action_navigation_category_to_navigation_author)
        }

    }

}