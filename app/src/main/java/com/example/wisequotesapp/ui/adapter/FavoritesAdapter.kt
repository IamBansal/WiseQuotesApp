package com.example.wisequotesapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.wisequotesapp.databinding.CustomFavItemBinding
import com.example.wisequotesapp.ui.model.Author

class FavoritesAdapter(private val fragment: Fragment, private val list: List<Author>): RecyclerView.Adapter<FavoritesAdapter.ViewHolder>() {

    class ViewHolder(view: CustomFavItemBinding) : RecyclerView.ViewHolder(view.root) {
        val share : ImageView = view.share
        val addToFav : ImageView = view.addToFav
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CustomFavItemBinding.inflate(LayoutInflater.from(fragment.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.share.setOnClickListener {
            Toast.makeText(fragment.context, "Trying to share the quote to others.", Toast.LENGTH_SHORT).show()
        }
        holder.addToFav.setOnClickListener {
            Toast.makeText(fragment.context, "Trying to add the quote to favorites.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}