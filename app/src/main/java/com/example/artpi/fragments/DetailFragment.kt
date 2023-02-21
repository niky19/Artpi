package com.example.artpi.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.artpi.databinding.FragmentDetailBinding
import com.example.artpi.viewModel.ArtworkViewModel


class DetailFragment : Fragment() {

    private val model: ArtworkViewModel by activityViewModels()
    lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    /* override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
         super.onViewCreated(view, savedInstanceState)
         model.selectedArtwork.observe(viewLifecycleOwner, Observer {
             val user = it
             Glide.with(requireContext())
                 .load((artwork as Artwork).url)
                 .diskCacheStrategy(DiskCacheStrategy.ALL)
                 .centerCrop()
                 .into(binding.imageView)
             binding.textViewName.text = artwork.title
         })
     }*/
}

