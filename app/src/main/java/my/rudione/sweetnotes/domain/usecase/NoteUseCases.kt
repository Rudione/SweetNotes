package my.rudione.sweetnotes.domain.usecase

data class NoteUseCases(
    val getNotesUseCase: GetNotesUseCase,
    val deleteNotesUseCase: DeleteNotesUseCase,
    val addNoteUseCase: AddNoteUseCase,
    val getNoteUseCases: GetNoteUseCase
)