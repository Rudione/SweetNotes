package com.example.sweetnotes.presentation.util

sealed class UiEvent {
    data class ShowSnack(val message: String): UiEvent()
    object SaveNote
}