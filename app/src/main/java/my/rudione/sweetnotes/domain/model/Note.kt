package my.rudione.sweetnotes.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import my.rudione.sweetnotes.presentation.ui.theme.*

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