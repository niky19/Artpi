package com.example.artpi.model

import com.google.gson.annotations.SerializedName

data class Artwork(
    val config: Config,
    val `data`: List<Data>,
    val info: Info,
    val pagination: Pagination
)