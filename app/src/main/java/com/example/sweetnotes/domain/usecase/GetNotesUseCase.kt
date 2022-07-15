package com.example.sweetnotes.domain.usecase

import androidx.compose.ui.text.toLowerCase
import com.example.sweetnotes.domain.model.Note
import com.example.sweetnotes.domain.repository.NoteRepository
import com.example.sweetnotes.domain.util.NoteOrder
import com.example.sweetnotes.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotesUseCase(
    private val repository: NoteRepository
) {
    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ): Flow<Unit> {
        return repository.getNotes().map { notes ->
            when(noteOrder.orderType) {
                is OrderType.Ascending -> {
                    when(noteOrder) {
                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                        is NoteOrder.Title -> notes.sortedBy { it.title.toLowerCase() }
                    }
                }

                is OrderType.Descending -> {
                    when(noteOrder) {
                        is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
                        is NoteOrder.Color -> notes.sortedByDescending { it.color }
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.toLowerCase() }
                    }
                }
            }
        }
    }
}