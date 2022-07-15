package com.example.sweetnotes.domain.usecase

import com.example.sweetnotes.domain.model.Note
import com.example.sweetnotes.domain.repository.NoteRepository

class DeleteNotesUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}