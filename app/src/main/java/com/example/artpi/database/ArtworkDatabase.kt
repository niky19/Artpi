package com.example.artpi.database

import androidx.room.Database
import androidx.room.RoomDatabase

class ArtworkDatabase {
    @Database(entities = arrayOf(ArtworkEntity::class), version = 1)
    abstract class ContactDatabase : RoomDatabase() {
        abstract fun contactDao(): ArtworkDao
    }


}
