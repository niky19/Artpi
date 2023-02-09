package com.example.artpi.database

import android.app.Application
import androidx.room.Room

class ArtworkApplication : Application() {
    companion object {
        lateinit var database: ArtworkDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            this,
            ArtworkDatabase::class.java,
            "ContactDatabase"
        ).build()
    }
}
