package my.rudione.sweetnotes.presentation.ui.notes.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import my.rudione.sweetnotes.domain.model.Note

@Composable
fun NoteItem(
    note: Note,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 10.dp,
    cutCornerSize: Dp = 30.dp,
    onDeleteClick: () -> Unit
) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color.White.copy(0.1f),
                shape = RoundedCornerShape(16.dp)
            )
            .clip(RoundedCornerShape(16.dp))
    ) {
        Box(
            modifier = modifier
        ) {
            Canvas(modifier = Modifier.matchParentSize()) {
                val clipPath = Path().apply {
                    lineTo(size.width, 0f)
                    lineTo(size.width, cutCornerSize.toPx())
                    lineTo(size.width, size.height)
                    lineTo(0f, size.height)
                    close()
                }
                clipPath(clipPath) {
                    drawRoundRect(
                        color = Color(note.color),
                        size = size,
                        cornerRadius = CornerRadius(cornerRadius.toPx())
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .padding(end = 32.dp)
            ) {
                Text(
                    text = note.title,
                    style = MaterialTheme.typography.h5,
                    color = Color.DarkGray,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = note.content,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface,
                    maxLines = 10,
                    overflow = TextOverflow.Ellipsis
                )
            }
            IconButton(
                onClick = onDeleteClick,
                modifier = Modifier.align(Alignment.BottomEnd)
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete note",
                    tint = Color.DarkGray
                )
            }
        }
    }
}