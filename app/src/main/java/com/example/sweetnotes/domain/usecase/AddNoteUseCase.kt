package com.example.sweetnotes.domain.usecase

import com.example.sweetnotes.domain.model.InvalidNoteException
import com.example.sweetnotes.domain.model.Note
import com.example.sweetnotes.domain.repository.NoteRepository

class AddNoteUseCase(
    private val repository: NoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("The title of note can't be empty")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("Content blank of note can't be empty")
        }
        return repository.insertNote(note)
    }
}