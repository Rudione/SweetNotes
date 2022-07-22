package my.rudione.sweetnotes.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val title: String,
    val content: String,
    val timestamp: Long,
   // val color: List<Colors>
) {
    companion object {
      //  val noteColors = Colors.values()
    }
}