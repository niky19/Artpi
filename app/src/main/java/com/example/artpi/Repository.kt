package com.example.artpi

import com.example.artpi.model.Data


class Repository {
    private val apiInterface = ApiInterface.create()

    suspend fun getData() = apiInterface.getData("https://api.artic.edu/api/v1/artworks")


}



