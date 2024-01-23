package com.example.kotlin4_not.data.local.room.entites

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 4, exportSchema = false)

abstract class Database : RoomDatabase() {

    abstract fun noteDao(): NoteDao?

}