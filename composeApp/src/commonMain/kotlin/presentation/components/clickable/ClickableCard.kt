package presentation.components.clickable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ClickableCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    elevation: Dp = 0.dp,
    cornerSize: Dp = 12.dp,
    content: @Composable () -> Unit,
) {
    Card(
        modifier = modifier
            .pointerHoverIcon(PointerIcon.Hand)
            .clickable { onClick() }
        ,
        elevation = elevation,
        shape = RoundedCornerShape(size = cornerSize),
        backgroundColor = MaterialTheme.colors.onPrimary,
    ) {
        content()
    }
}