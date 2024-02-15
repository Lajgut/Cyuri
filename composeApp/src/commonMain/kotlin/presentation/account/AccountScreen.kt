package presentation.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import presentation.components.HeaderComponent

@Composable
fun AccountScreen() {
    val selectedPosition = mutableStateOf(0)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
    ) {
        HeaderComponent()
        Row(modifier = Modifier.padding(top = 40.dp)) {
            CategoriesContent(
                modifier = Modifier.weight(1f),
                selectedPosition = selectedPosition
            )
            CategoryInfoContent(modifier = Modifier.weight(2f))
        }
    }
}

@Composable
private fun CategoriesContent(modifier: Modifier, selectedPosition: MutableState<Int>) {
    Column(modifier = modifier) {
        Text(
            text = "Профиль",
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.Bold,
        )

        TextButton(
            modifier = Modifier
                .padding(top = 32.dp)
                .background(color = if (selectedPosition.value == 0) MaterialTheme.colors.onBackground else Color.Transparent),
            onClick = { selectedPosition.value = 0}
        ) {
            Text(
                text = "Ваши данные",
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.primaryVariant,
            )
        }

        TextButton(
            modifier = Modifier
                .background(color = if (selectedPosition.value == 1) MaterialTheme.colors.onBackground else Color.Transparent),
            onClick = { selectedPosition.value = 1},
        ) {
            Text(
                text = "Ваши заказы",
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.primaryVariant,
            )
        }
    }
}

@Composable
private fun CategoryInfoContent(modifier: Modifier) {
    Column {
        Text(
            text = "Ваш профиль",
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.Bold,
        )

        ProfileContent(
            modifier = Modifier.background(color = MaterialTheme.colors.surface),
        )
    }
}

@Composable
private fun ProfileContent(modifier: Modifier) {
    Column(modifier = modifier) {
        PhotoNameRow()
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
