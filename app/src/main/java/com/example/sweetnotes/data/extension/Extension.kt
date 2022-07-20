package com.example.sweetnotes.data.extension

import androidx.compose.ui.graphics.Color
import com.example.sweetnotes.data.model.NoteModel
import com.example.sweetnotes.domain.model.Note

fun NoteModel.toNote(): Note {
    return Note(
        id, title, content, timestamp, color = 1
    )
}
