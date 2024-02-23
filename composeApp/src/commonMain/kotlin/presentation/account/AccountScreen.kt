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
import presentation.components.UserInfoComponent
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
            onOrdersClick = { onScreenChanged(Destinations.OrdersHistory) }
        )
        Column(modifier = Modifier.padding(top = 40.dp)) {
            Text(
                text = "Профиль",
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold,
            )

            val contentModifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth(0.6f)

            ProfileCard(modifier = contentModifier)
            LocationCard(modifier = contentModifier)
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun ProfileCard(modifier: Modifier) {
    AccountItemCard(modifier = modifier) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = "Так вас видит специалист",
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold,
            )

            UserInfoComponent()
        }
    }
}

@Composable
private fun LocationCard(modifier: Modifier) {
    AccountItemCard(modifier = modifier) {
        Column(Modifier.padding(12.dp)) {
            Text(
                text = "Ваш Адрес",
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold,
            )

            Text(
                modifier = Modifier.padding(vertical = 16.dp),
                text = "Dubai Motor city, Dubai autodrome turn 5 on the Pirelli name",
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
