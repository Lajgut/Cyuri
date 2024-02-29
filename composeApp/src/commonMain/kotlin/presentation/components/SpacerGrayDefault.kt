package presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp

@Composable
fun SpacerGrayDefault(
    modifier: Modifier = Modifier,
    shouldHide: Boolean = false,
) {
    Spacer(
        modifier = modifier
            .height(0.5.dp)
            .fillMaxWidth()
            .alpha(if (!shouldHide) 0.2f else 0f)
            .background(color = MaterialTheme.colors.primaryVariant),
    )
}