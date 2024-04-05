package presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun SelectableText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle,
    textColor: Color = Color.Unspecified,
    fontWeight: FontWeight? = null,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    ClickableText(
        modifier = modifier
            .background(
                color = if (isSelected) MaterialTheme.colors.onBackground else MaterialTheme.colors.background,
                shape = RoundedCornerShape(8.dp),
            ),
        text = text,
        style = style,
        contentColor = MaterialTheme.colors.onBackground,
        textColor = textColor,
        fontWeight = fontWeight,
        onClick = onClick,
    )
}