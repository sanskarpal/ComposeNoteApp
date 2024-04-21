package com.example.composenoteapp.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.composenoteapp.data.NotesDateSource
import com.example.composenoteapp.model.Note

class NoteViewModel: ViewModel() {

    private var noteList = mutableStateListOf<Note>()

    init {
        noteList.addAll(NotesDateSource().loadNotes())
    }

    fun addNote(note: Note){
        noteList.add(note)
    }

    fun removeNote(note:Note){
        noteList.remove(note)
    }

    fun getAllNotes(): List<Note>{
        return noteList
    }
}