package com.example.artpi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.artpi.MyOnClickListener
import com.example.artpi.R
import com.example.artpi.databinding.ItemArtworkBinding
import com.example.artpi.model.Data

class ArtworkAdapter(
    private val artworks: MutableList<Data>,
    private val listener: MyOnClickListener
) :
    RecyclerView.Adapter<ArtworkAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemArtworkBinding.bind(view)
        fun setListener(artwork: Data) {
            binding.root.setOnClickListener {
                listener.onClick(artwork)
            }
        }
    }

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_artwork, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val artwork = artworks[position]
        with(holder) {
            setListener(artwork)
            binding.textViewTitle.text = artwork.title
            binding.textViewOrder.text = artwork.id.toString()
            Glide.with(context)
                .load(artwork.image_id)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .circleCrop()
                .into(binding.imgPhoto)
        }
    }

    override fun getItemCount(): Int {
        return artworks.size
    }


}