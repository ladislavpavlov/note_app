package com.example.note

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.note.adapter.ListAdapter
import com.example.note.repository.NoteViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mNoteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fbAdd.setOnClickListener { startActivity(Intent(this, AddActivity::class.java)) }

        var adapter = ListAdapter()

        recyclerView.apply {
            adapter = adapter
            layoutManager = LinearLayoutManager(applicationContext)
        }

        mNoteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        mNoteViewModel.readAllNote.observe(this, Observer { note ->
            adapter.setData(note)
        })
    }
}