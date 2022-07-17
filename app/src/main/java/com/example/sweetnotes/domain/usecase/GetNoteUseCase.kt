package com.example.sweetnotes.domain.usecase

import com.example.sweetnotes.domain.model.Note
import com.example.sweetnotes.domain.repository.NoteRepository

class GetNoteUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(num: Int): Note? {
        return repository.getNoteById(num)
    }
}