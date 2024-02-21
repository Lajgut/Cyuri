package presentation.orders

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import presentation.components.HeaderComponent
import presentation.components.UserInfoComponent
import presentation.navigation.Destinations

private const val ORDER_DETAILS_POSITION = 0
private const val EXPERTS_LIST_POSITION = 1

@Composable
fun OrdersScreen(
    modifier: Modifier,
    onScreenChanged: (destination: Destinations) -> Unit,
) {
    val selectedItemPosition = mutableIntStateOf(0)

    Column(modifier = modifier) {
        HeaderComponent(
            onLogoClick = { onScreenChanged(Destinations.Home) },
            onOrdersClick = { onScreenChanged(Destinations.OrdersHistory) },
            onAccountClick = { onScreenChanged(Destinations.Account) }
        )

        Row {
            CategoriesColumn(
                modifier = Modifier.weight(1f),
                selectedItemPosition = selectedItemPosition,
            )
            when (selectedItemPosition.intValue) {
                ORDER_DETAILS_POSITION -> OrderDetails(modifier = Modifier.weight(2f).fillMaxWidth())
                EXPERTS_LIST_POSITION -> ExpertsList(modifier = Modifier.weight(2f).fillMaxWidth())
            }
        }
    }
}

@Composable
private fun CategoriesColumn(
    modifier: Modifier,
    selectedItemPosition: MutableIntState,
) {
    Column(modifier = modifier) {
        SelectableText(
            modifier = Modifier.fillMaxWidth(),
            text = "Разместить заказ",
            isSelected = selectedItemPosition.value == ORDER_DETAILS_POSITION
        ) {
            selectedItemPosition.value = ORDER_DETAILS_POSITION
        }

        SelectableText(
            modifier = Modifier.fillMaxWidth(),
            text = "Выбор специалиста",
            isSelected = selectedItemPosition.value == EXPERTS_LIST_POSITION
        ) {
            selectedItemPosition.value = EXPERTS_LIST_POSITION
        }
    }
}

@Composable
private fun OrderDetails(modifier: Modifier) {
    var text by remember { mutableStateOf("") }

    Column(modifier = modifier) {
        Text(text = "Что нужно сделать?")

        TextField(
            shape = RoundedCornerShape(8.dp),
            value = text,
            onValueChange = { text = it },
            textStyle = MaterialTheme.typography.h6,
            placeholder = { Text(text = "Опишите специалисту, детали заказа") },
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colors.primary,
                placeholderColor = MaterialTheme.colors.primaryVariant,
                backgroundColor = MaterialTheme.colors.onPrimary,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
        )

        Card(backgroundColor = MaterialTheme.colors.onPrimary) {
            UserInfoComponent()
        }
    }
}

@Composable
private fun ExpertsList(modifier: Modifier) {
    Column(modifier = modifier) {  }
}

@Composable
private fun SelectableText(
    modifier: Modifier,
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    Text(
        modifier = modifier
            .selectable(
                selected = isSelected,
                enabled = true,
                onClick = onClick,
            ),
        text = text,
        style = MaterialTheme.typography.subtitle1,
        color = MaterialTheme.colors.primary,
        fontWeight = FontWeight.Bold,
    )
}
