package com.example.wisequotesapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.wisequotesapp.databinding.CustomAuthorItemBinding
import com.example.wisequotesapp.databinding.CustomThemeItemBinding
import com.example.wisequotesapp.ui.model.Author

//TODO change the class here
class ThemeAdapter(private val fragment: Fragment, private val list: List<Author>): RecyclerView.Adapter<ThemeAdapter.ViewHolder>() {

    class ViewHolder(view: CustomThemeItemBinding) : RecyclerView.ViewHolder(view.root) {
        val text: TextView = view.text
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CustomThemeItemBinding.inflate(LayoutInflater.from(fragment.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val author = list[position]
        holder.text.text = author.text
    }

    override fun getItemCount(): Int {
        return list.size
    }

}