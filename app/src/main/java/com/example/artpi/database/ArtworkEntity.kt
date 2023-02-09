package com.example.artpi.database

import androidx.room.Entity
import androidx.room.PrimaryKey

class ArtworkEntity {
    @Entity(tableName = "ArtworkEntity")
    data class ArtworkEntity(
        @PrimaryKey val id: Int,
        val image: String,
        val name: String,
        val type: String,
        val url: String
    )
}