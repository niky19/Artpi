package com.example.artpi.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.artpi.adapter.ArtworkAdapter
import com.example.artpi.databinding.FragmentRecyclerViewBinding
import com.example.artpi.viewModel.ArtworkViewModel


class RecyclerViewFragment : Fragment() {
    lateinit var artworkAdapter: ArtworkAdapter
    lateinit var binding: FragmentRecyclerViewBinding
    val artworkViewModel = ViewModelProvider(requireActivity())[ArtworkViewModel::class.java]

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecyclerViewBinding.inflate(layoutInflater)
        return binding.root
    }

}
