package com.example.sweetnotes.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.sweetnotes.domain.common.Colors

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
        val noteColors = Colors.values()
    }
}

class InvalidNoteException(message: String): Exception(message)