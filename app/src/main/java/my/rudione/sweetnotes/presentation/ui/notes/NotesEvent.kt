package my.rudione.sweetnotes.presentation.ui.notes

import my.rudione.sweetnotes.domain.model.Note
import my.rudione.sweetnotes.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}