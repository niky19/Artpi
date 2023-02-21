package com.example.artpi.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.artpi.MyOnClickListener
import com.example.artpi.R
import com.example.artpi.adapter.ArtworkAdapter
import com.example.artpi.databinding.FragmentRecyclerViewBinding
import com.example.artpi.model.Data
import com.example.artpi.viewModel.ArtworkViewModel


class RecyclerViewFragment : Fragment(), MyOnClickListener {
    lateinit var artworkAdapter: ArtworkAdapter
    lateinit var binding: FragmentRecyclerViewBinding
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager
    val artworkViewModel = ViewModelProvider(requireActivity())[ArtworkViewModel::class.java]

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecyclerViewBinding.inflate(layoutInflater)
        return binding.root
    }

    private fun getArtworks(): MutableList<Data> {
        val artworks = mutableListOf<Data>()
        artworks.add(Data("link", "Nom", 4, "45", 45, "a", "nightawks"))
        return artworks
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        artworkViewModel.fetchData("artworks")
        artworkViewModel.showAllArtworks()
        super.onViewCreated(view, savedInstanceState)
        artworkAdapter = ArtworkAdapter(getArtworks(), this)
        linearLayoutManager = LinearLayoutManager(context)

        binding.recyclerView.apply {
            setHasFixedSize(true) //Optimitza el rendiment de l’app
            layoutManager = linearLayoutManager
            adapter = artworkAdapter

        }

    }

    override fun onClick(artwork: Data) {
        parentFragmentManager.setFragmentResult(
            "Artwork", bundleOf("artworks" to artwork)
        )
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container_view, DetailFragment())
            setReorderingAllowed(true)
            addToBackStack(null)
            commit()
        }

    }

}
