package com.example.noteapp

import android.app.Application
import androidx.room.Room
import com.example.kotlin4_not.data.local.room.entites.Database

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            applicationContext,
            Database::class.java,
            "my_database"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    companion object {

        lateinit var database: Database
            private set
    }

}

