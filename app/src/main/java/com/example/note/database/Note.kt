package com.example.note.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note (
    @PrimaryKey(autoGenerate = true)
    var id : Long,
    var name: String,
    var surname: String
 )