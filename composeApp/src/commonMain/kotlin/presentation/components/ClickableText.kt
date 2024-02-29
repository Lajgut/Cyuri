package presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.material.*
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
    textColor: Color = Color.Unspecified,
    contentColor: Color = Color.Unspecified,
    fontWeight: FontWeight? = null,
    onClick: () -> Unit,
) {
    TextButton(
        modifier = modifier
            .pointerHoverIcon(PointerIcon.Hand),
        colors = ButtonDefaults.textButtonColors(
            contentColor = contentColor,
        ),
        onClick = onClick,
    ) {
        Text(
            text = text,
            style = style,
            color = textColor,
            fontWeight = fontWeight,
        )
    }
}