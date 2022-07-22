package my.rudione.sweetnotes.data.extension

import my.rudione.sweetnotes.data.model.NoteModel
import my.rudione.sweetnotes.domain.model.Note

fun NoteModel.toNote(): Note {
    return Note(
        id, title, content, timestamp, color = 1
    )
}
