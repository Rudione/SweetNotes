package com.example.sweetnotes.presentation.model

data class NoteTextFieldState(
    val text: String = "",
    val hint: String = "",
    val isVisibleHint: Boolean = true
)