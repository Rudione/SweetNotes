package my.rudione.sweetnotes.presentation.ui.editnote.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun HintTextField(
    text: String,
    hint: String,
    modifier: Modifier = Modifier,
    isHintVisible: Boolean = false,
    onValueChange: (String) -> Unit,
    onFocusChange: (FocusState) -> Unit,
    singleLine: Boolean = false,
    textStyle: TextStyle = TextStyle()
) {
    Card(
        elevation = 12.dp,
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color.White.copy(0.2f),
                shape = RoundedCornerShape(6.dp)
            )
            .clip(RoundedCornerShape(12.dp))
            .shadow(12.dp)
    ) {
        Box(
            modifier = modifier
        ) {
            BasicTextField(
                value = text,
                onValueChange = onValueChange,
                singleLine = singleLine,
                textStyle = textStyle,
                modifier = Modifier
                    .fillMaxWidth()
                    .onFocusChanged {
                        onFocusChange(it)
                    }
            )
            if (isHintVisible) {
                Text(
                    text = hint,
                    style = textStyle,
                    color = Color.Black
                )
            }
        }
    }
}