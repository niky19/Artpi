package com.example.artpi.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.artpi.Repository
import com.example.artpi.database.ArtworkApplication.Companion.database
import com.example.artpi.database.ArtworkDatabase
import com.example.artpi.database.CharacterApplication.Companion.database
import com.example.artpi.model.Data
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ArtworkViewModel : ViewModel() {
    val artworkData = MutableLiveData<Data>()
    var repo = Repository()

    init {
        fetchData("artwork")
    }

    fun fetchData(url: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repo.getData()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    artworkData.postValue(response.body())
                }
            }
        }
    }

    fun getAllArtworks() {
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.IO) {
                val characters = ArtworkDatabase.database.characterDao().getAllCharacters()
                changeToFavoritesArtworks(Artworks)
            }
        }
    }

    private fun changeToFavoritesArtworks(artworks: Any) {
        TODO("Not yet implemented")
    }


}