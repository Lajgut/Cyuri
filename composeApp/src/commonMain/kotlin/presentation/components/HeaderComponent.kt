package presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
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
            Text(
                modifier = Modifier.clickable { onLogoClick() },
                text = "Cyuri.ru",
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.secondary,
                fontWeight = FontWeight.Bold,
            )

            Text(
                modifier = Modifier.padding(horizontal = 40.dp),
                text = "город: Дубай",
                style = MaterialTheme.typography.subtitle1,
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            TextButton(
                modifier = Modifier.padding(horizontal = 20.dp),
                onClick = onOrdersClick,
            ) {
                Text(
                    text = "Ваши заказы",
                    style = MaterialTheme.typography.subtitle1,
                )
            }

            TextButton(
                onClick = onAccountClick,
            ) {
                Text(
                    text = "Аккаунт",
                    style = MaterialTheme.typography.subtitle1,
                )
            }
        }
    }
}
