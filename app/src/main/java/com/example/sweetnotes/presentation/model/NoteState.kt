package com.example.sweetnotes.presentation.model

import com.example.sweetnotes.domain.model.Note
import com.example.sweetnotes.domain.util.NoteOrder
import com.example.sweetnotes.domain.util.OrderType

data class NoteState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)