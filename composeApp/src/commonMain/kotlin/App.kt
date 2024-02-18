import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import presentation.account.AccountScreen
import presentation.home.HomeScreen
import presentation.navigation.Destinations
import presentation.orders.OrdersScreen
import theme.AppTheme

@Composable
fun App() {

    var destination by mutableStateOf<Destinations>(Destinations.Home)

    val webModifier = Modifier
        .padding(start = 310.dp, end = 310.dp)

    AppTheme {
        Box(Modifier.background(color = MaterialTheme.colors.background)) {
            when (destination) {
                Destinations.Home -> HomeScreen(webModifier) { destination = it }
                Destinations.Account -> AccountScreen(webModifier) { destination = it }
                Destinations.OrdersHistory -> TODO()
                Destinations.Order -> OrdersScreen(webModifier) { destination = it }
            }
        }
    }
}
