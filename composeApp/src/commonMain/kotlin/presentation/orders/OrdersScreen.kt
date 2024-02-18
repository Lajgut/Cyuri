package presentation.orders

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import presentation.navigation.Destinations

private const val ORDER_DETAILS_POSITION = 0
private const val EXPERTS_LIST_POSITION = 1

@Composable
fun OrdersScreen(
    modifier: Modifier,
    onScreenChanged: (destination: Destinations) -> Unit,
) {
    val selectedItemPosition = mutableIntStateOf(0)

    Row(modifier = modifier) {
        CategoriesColumn(
            modifier = Modifier.weight(1f),
            selectedItemPosition = selectedItemPosition,
        )
        when (selectedItemPosition.intValue) {
            ORDER_DETAILS_POSITION -> OrderDetails()
            EXPERTS_LIST_POSITION -> ExpertsList()
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
private fun OrderDetails() {

}

@Composable
private fun ExpertsList() {

}

@Composable
private fun SelectableText(
    modifier: Modifier,
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    Text(
        modifier = modifier
            .selectable(selected = isSelected),
        text = text,
        style = MaterialTheme.typography.subtitle1,
        color = MaterialTheme.colors.primary,
        fontWeight = FontWeight.Bold,
    )
}
