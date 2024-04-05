package theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.intl.Locale

val LocalStringResources = staticCompositionLocalOf { stringResourcesRu() }

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    val colorPalette = if (isSystemInDarkTheme()) {
        //darkThemeColors
        lightThemeColors
    } else {
        lightThemeColors
    }

    val stringResources = when (Locale.current.language) {
        "En" -> stringResourcesRu()
        else -> stringResourcesRu()
    }

    CompositionLocalProvider(LocalStringResources provides stringResources) {
        content()
    }

    MaterialTheme(
        colors = colorPalette,
        typography = appTypography,
    ) {
        content()
    }
}