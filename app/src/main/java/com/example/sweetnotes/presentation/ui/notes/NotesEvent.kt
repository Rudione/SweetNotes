package com.example.sweetnotes.presentation.ui.notes

import com.example.sweetnotes.domain.model.Note
import com.example.sweetnotes.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}