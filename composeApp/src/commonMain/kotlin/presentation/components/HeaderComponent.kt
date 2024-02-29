package presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun HeaderComponent(
    modifier: Modifier = Modifier,
    onLogoClick: () -> Unit,
    onAccountClick: () -> Unit,
    onOrdersClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            ClickableText(
                text = "Cyuri.ru",
                style = MaterialTheme.typography.h5,
                textColor = MaterialTheme.colors.secondary,
                fontWeight = FontWeight.Bold,
                onClick = onLogoClick
            )

            Text(
                modifier = Modifier.padding(horizontal = 40.dp),
                text = "город: Дубай",
                style = MaterialTheme.typography.subtitle1,
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            ClickableText(
                modifier = Modifier.padding(horizontal = 20.dp),
                text = "Ваши заказы",
                style = MaterialTheme.typography.subtitle1,
                onClick = onOrdersClick,
            )

            ClickableText(
                onClick = onAccountClick,
                text = "Аккаунт",
                style = MaterialTheme.typography.subtitle1,
            )
        }
    }
}
