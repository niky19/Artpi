package com.example.artpi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.artpi.OnClickListener
import com.example.artpi.R
import com.example.artpi.databinding.ItemArtworkBinding
import com.bumptech.glide.Glide

class ArtworkAdapter(private val artworks: MutableList<Artwork>, private val listener: OnClickListener):
    RecyclerView.Adapter<ArtworkAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_artwork, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val artwork = artworks[position]
        with(holder){
            setListener(artwork)
            binding.textViewTitle.text = artwork.title
            binding.textViewOrder.text = artwork.id.toString()
            Glide.with(context)
                .load(artwork.url)
                .centerCrop()
                .circleCrop()
                .into(binding.imgPhoto)
        }
    }

    override fun getItemCount(): Int {
        return artworks.size
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ItemArtworkBinding.bind(view)

        fun setListener(artwork: Artwork){
            binding.root.setOnClickListener {
                listener.onClick(artwork)
            }
        }
    }
}