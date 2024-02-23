package presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

@Composable
fun ClickableText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle,
    color: Color,
    fontWeight: FontWeight,
    onClick: () -> Unit,
) {
    Text(
        modifier = modifier
            .pointerHoverIcon(PointerIcon.Hand)
            .clickable { onClick() },
        text = text,
        style = style,
        color = color,
        fontWeight = fontWeight,
    )
}