package com.example.artpi.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.artpi.Repository
import com.example.artpi.model.Artwork
import com.example.artpi.model.Data
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ArtworkViewModel : ViewModel() {
    val data = MutableLiveData<Data>()
    var repo = Repository()

    init {
        fetchData("artwork")
    }

    fun fetchData(url: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repo.getData()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    data.postValue(response.body())
                }
            }
        }
    }

}