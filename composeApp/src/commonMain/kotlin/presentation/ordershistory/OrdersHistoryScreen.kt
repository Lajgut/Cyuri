package presentation.ordershistory

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import cyuri.composeapp.generated.resources.Res
import cyuri.composeapp.generated.resources.account_photo_mock
import cyuri.composeapp.generated.resources.orders_history_create
import cyuri.composeapp.generated.resources.orders_history_title
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import presentation.components.HeaderComponent
import presentation.components.TitleTextComponent
import presentation.components.clickable.ClickableCard
import presentation.navigation.Destinations

@OptIn(ExperimentalResourceApi::class)
@Composable
fun OrdersHistoryScreen(
    modifier: Modifier,
    onScreenChanged: (destination: Destinations) -> Unit,
) {

    Column(modifier = modifier.fillMaxSize()) {
        HeaderComponent(
            onLogoClick = { onScreenChanged(Destinations.Home) },
            onOrdersClick = { },
            onAccountClick = { onScreenChanged(Destinations.Account) }
        )

        TitleTextComponent(text = stringResource(Res.string.orders_history_title))
        Spacer(modifier = Modifier.height(24.dp))
        CreateOrderCard(onScreenChanged = onScreenChanged)
        Spacer(modifier = Modifier.height(16.dp))

        repeat(4) {
            OrderHistoryItem(
                orderName = "Ремонт холодильников",
                specialistName = "Холодильников починятор",
                specialistPhoto = Res.drawable.account_photo_mock,
                date = "вчера"
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun CreateOrderCard(onScreenChanged: (destination: Destinations) -> Unit) {
    ClickableCard(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.onPrimary),
        elevation = 1.dp,
        onClick = { onScreenChanged(Destinations.Order) },
    ) {
        Row(
            modifier = Modifier.padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(Res.string.orders_history_create),
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold,
            )

            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
            )
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun OrderHistoryItem(
    orderName: String,
    specialistName: String,
    specialistPhoto: DrawableResource,
    date: String,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.onPrimary),
        elevation = 1.dp,
        shape = RoundedCornerShape(size = 12.dp),
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = orderName,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = date,
                    style = MaterialTheme.typography.subtitle1,
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = specialistName,
                style = MaterialTheme.typography.subtitle1,
            )

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                modifier = Modifier.size(40.dp),
                painter = painterResource(specialistPhoto),
                contentDescription = null,
            )
        }
    }
}
