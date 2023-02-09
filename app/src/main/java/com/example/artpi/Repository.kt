package com.example.artpi


class Repository {
    private val apiInterface = ApiInterface.create()

    suspend fun getData() = apiInterface.getData("https://api.artic.edu/api/v1/artworks")


}



