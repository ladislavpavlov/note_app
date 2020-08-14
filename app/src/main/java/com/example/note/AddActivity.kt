package com.example.note

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.note.database.Note
import com.example.note.repository.NoteViewModel
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {

    private lateinit var mNoteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        mNoteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        buttonAdd.setOnClickListener { addNoteToDb(editName.text.toString(), editSurname.text.toString()) }
    }

    private fun addNoteToDb(name: String, surname: String) {
            //Create note object
            val note = Note(0, name, surname)
            //Add note to database
            mNoteViewModel.addNote(note)
            //Notification
            Toast.makeText(this, "Note was added!", Toast.LENGTH_LONG).show()

        openMainDisplay()
    }

    fun openMainDisplay () {
        startActivity(Intent(this, MainActivity::class.java))
    }
}