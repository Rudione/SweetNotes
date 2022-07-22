package my.rudione.sweetnotes.domain.usecase

import my.rudione.sweetnotes.domain.model.Note
import my.rudione.sweetnotes.domain.repository.NoteRepository

class DeleteNotesUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}