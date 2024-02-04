package theme

import androidx.compose.runtime.Immutable

@Immutable
data class StringResources(
    val appName: String = "Cyuri.ru",
    val mainTitle: String,
)

fun stringResourcesRu() = StringResources(
    appName = "Cyuri.ru",
    mainTitle = "Доверьте вашу проблему специалисту",
)
