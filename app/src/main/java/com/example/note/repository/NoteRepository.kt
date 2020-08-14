package com.example.note.repository

import androidx.lifecycle.LiveData
import com.example.note.database.Note
import com.example.note.database.NoteDao

class NoteRepository(private val noteDao: NoteDao) {

   val readAllNotes: LiveData<List<Note>> = noteDao.getNote()

   suspend fun addNote (note: Note) {
        noteDao.addNote(note)
    }
}