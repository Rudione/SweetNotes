package my.rudione.sweetnotes.presentation.ui.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import my.rudione.sweetnotes.domain.model.Note
import my.rudione.sweetnotes.domain.usecase.NoteUseCases
import my.rudione.sweetnotes.domain.util.NoteOrder
import my.rudione.sweetnotes.domain.util.OrderType
import my.rudione.sweetnotes.presentation.model.NoteState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val useCases: NoteUseCases
) : ViewModel() {

    private val _state = mutableStateOf(NoteState())
    val state: State<NoteState> = _state

    private var recentlyDeletedNote: Note? = null

    private var getNotesJob: Job? = null

    init {
        getNotes(NoteOrder.Date(OrderType.Descending))
    }

    fun onEvent(notesEvent: NotesEvent) {
        when (notesEvent) {
            is NotesEvent.Order -> {
                if (state.value.noteOrder::class == notesEvent.noteOrder::class &&
                    state.value.noteOrder.orderType == notesEvent.noteOrder.orderType
                ) {
                    return
                }
                getNotes(notesEvent.noteOrder)
            }
            is NotesEvent.RestoreNote -> {
                viewModelScope.launch {
                    useCases.addNoteUseCase(recentlyDeletedNote ?: return@launch)
                }
            }
            is NotesEvent.DeleteNote -> {
                viewModelScope.launch {
                    useCases.deleteNotesUseCase(notesEvent.note)
                    recentlyDeletedNote = notesEvent.note
                }
            }
            is NotesEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun getNotes(noteOrder: NoteOrder) {
        getNotesJob?.cancel()
        getNotesJob = useCases.getNotesUseCase(noteOrder)
            .onEach { notes ->
                _state.value = state.value.copy(
                    notes = notes,
                    noteOrder = noteOrder
                )
            }
            .launchIn(viewModelScope)
    }
}