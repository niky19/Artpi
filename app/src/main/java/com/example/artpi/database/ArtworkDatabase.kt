package com.example.artpi.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ArtworkEntity::class], version = 1)
abstract class ArtworkDatabase : RoomDatabase() {
    abstract fun artworkDao(): ArtworkDao
}



