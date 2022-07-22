package my.rudione.sweetnotes.presentation.model

import my.rudione.sweetnotes.domain.model.Note
import my.rudione.sweetnotes.domain.util.NoteOrder
import my.rudione.sweetnotes.domain.util.OrderType

data class NoteState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)