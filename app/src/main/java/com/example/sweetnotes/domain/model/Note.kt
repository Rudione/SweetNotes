package com.example.sweetnotes.domain.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.sweetnotes.presentation.ui.theme.*

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int
) {
    companion object {
        val noteColors = listOf(
            blueTop, luxuryBlue, bottomBlue, pinkTop, roseMedium, darkPurple, darkBlue, blueForever, lightBlue
        )
    }
}

class InvalidNoteException(message: String): Exception(message)