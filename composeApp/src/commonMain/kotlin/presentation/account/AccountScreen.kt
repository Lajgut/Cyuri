package presentation.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import presentation.components.HeaderComponent
import presentation.navigation.Destinations

@Composable
fun AccountScreen(
    modifier: Modifier,
    onScreenChanged: (destination: Destinations) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
    ) {
        HeaderComponent(
            onLogoClick = { onScreenChanged(Destinations.Home) },
            onAccountClick = {},
            onOrdersClick = { onScreenChanged(Destinations.Orders) }
        )
        Column(
            modifier = Modifier
                .padding(top = 40.dp)
        ) {
            Text(
                text = "Профиль",
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold,
            )

            val contentModifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth(0.6f)

            ProfileContent(modifier = contentModifier)
            OrdersContent(modifier = contentModifier)
        }
    }
}

@Composable
private fun ProfileContent(modifier: Modifier) {
    AccountItemCard(modifier = modifier) {
        Column(Modifier.padding(12.dp)) {
            Text(
                text = "Так вас видит специалист",
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold,
            )
            PhotoNameRow()
        }
    }
}

@Composable
private fun OrdersContent(modifier: Modifier) {
    AccountItemCard(modifier = modifier) {
        Column(Modifier.padding(12.dp)) {
            Text(
                text = "Список ваших заказов",
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold,
            )
            PhotoNameRow()
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun PhotoNameRow() {
    Row {
        Image(
            modifier = Modifier
                .background(color = MaterialTheme.colors.onBackground)
                .height(50.dp)
                .width(50.dp)
                .clip(RoundedCornerShape(20.dp)),
            contentScale = ContentScale.FillBounds,
            painter = painterResource(""),
            contentDescription = null,
        )

        Column {
            Text(
                text = "Кирилл Битков",
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.primaryVariant,
            )

            Text(
                text = "+7 969 130 12 10",
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.primaryVariant,
            )
        }
    }
}

@Composable
private fun AccountItemCard(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Card(
        modifier = modifier,
        elevation = 4.dp,
        shape = RoundedCornerShape(size = 8.dp),
        backgroundColor = MaterialTheme.colors.onPrimary,
    ) {
        content()
    }
}
