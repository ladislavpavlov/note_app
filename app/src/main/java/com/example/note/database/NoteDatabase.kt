package com.example.note.database

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Note::class), version = 1)
abstract public class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        @Volatile
        private var INSTANCE: NoteDatabase? = null

        fun getDatabase(context: Context) : NoteDatabase {

            synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext, NoteDatabase::class.java, "note_db").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}