package com.example.composenoteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composenoteapp.data.NotesDateSource
import com.example.composenoteapp.model.Note
import com.example.composenoteapp.screen.NoteScreen
import com.example.composenoteapp.screen.NoteViewModel
import com.example.composenoteapp.ui.theme.ComposeNoteAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNoteAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   NotesApp()
                }
            }
        }
    }
}

@Composable
fun NotesApp(notesViewModel: NoteViewModel = viewModel()){
    val notesList = notesViewModel.getAllNotes()
    NoteScreen(notes = notesList,
        onAddNote = {
           notesViewModel.addNote(it)
        },
        onRemoveNote = {
            notesViewModel.removeNote(it)
        })
}

