package com.example.composenoteapp.model

import androidx.compose.runtime.MutableState
import java.time.LocalDateTime
import java.util.UUID

data class Note(
    val id: UUID = UUID.randomUUID(), //each time a note is created we will get unique id from this
    val title: String,
    val description: String,
    val entryDate: LocalDateTime = LocalDateTime.now()
)
