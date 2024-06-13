import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import presentation.account.AccountScreen
import presentation.home.HomeScreen
import presentation.navigation.Destinations
import presentation.orders.OrdersScreen
import presentation.ordershistory.OrdersHistoryScreen
import theme.AppTheme

@Composable
fun App() {
    var destination by mutableStateOf<Destinations>(Destinations.OrdersHistory)

    val webModifier = Modifier
        .padding(start = 310.dp, end = 310.dp)

    AppTheme {
        Box(Modifier.background(color = MaterialTheme.colors.background)) {
            when (destination) {
                Destinations.Home -> HomeScreen(webModifier) { destination = it }
                Destinations.Account -> AccountScreen(webModifier) { destination = it }
                Destinations.OrdersHistory -> OrdersHistoryScreen(webModifier) { destination = it }
                Destinations.Order -> OrdersScreen(
                    modifier = webModifier,
                    categoryName = "Сантехника"
                ) {
                    destination = it
                }
            }
        }
    }
}
