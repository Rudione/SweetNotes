package my.rudione.sweetnotes.domain.usecase

import my.rudione.sweetnotes.domain.model.Note
import my.rudione.sweetnotes.domain.repository.NoteRepository

class GetNoteUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(num: Int): Note? {
        return repository.getNoteById(num)
    }
}