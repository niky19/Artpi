package com.example.artpi.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query

@Dao
interface ArtworkDao {
    @Query("SELECT * FROM ArtworkEntity")
    fun showAllArtworks(): MutableList<ArtworkEntity>

    @Query("SELECT count(*) FROM ArtworkEntity where id = :id")
    fun getArtworkById(id: Int): Int

    @Delete
    fun deleteArtwork(artwork: ArtworkEntity)
}
