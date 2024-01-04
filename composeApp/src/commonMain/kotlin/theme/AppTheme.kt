import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import theme.appTypography


@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    val colorPalette = if (isSystemInDarkTheme()) {
        darkThemeColors
    } else {
        lightThemeColors
    }

    MaterialTheme(
        colors = colorPalette,
        typography = appTypography,
    ) {
        content()
    }
}