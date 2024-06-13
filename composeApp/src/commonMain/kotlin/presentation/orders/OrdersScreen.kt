package presentation.orders

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import cyuri.composeapp.generated.resources.*
import cyuri.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource
import presentation.components.*
import presentation.components.orders.SpecialistInfoComponent
import presentation.navigation.Destinations

private const val ORDER_DETAILS_POSITION = 0
private const val EXPERTS_LIST_POSITION = 1

@Composable
fun OrdersScreen(
    modifier: Modifier,
    categoryName: String,
    onScreenChanged: (destination: Destinations) -> Unit,
) {
    var selectedItemPosition by remember { mutableStateOf(0) }

    Column(modifier = modifier.fillMaxSize()) {
        HeaderComponent(
            onLogoClick = { onScreenChanged(Destinations.Home) },
            onOrdersClick = { onScreenChanged(Destinations.OrdersHistory) },
            onAccountClick = { onScreenChanged(Destinations.Account) }
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(60.dp)
        ) {
            CategoriesColumn(
                modifier = Modifier.weight(4f),
                selectedItemPosition = selectedItemPosition,
            ) {
                selectedItemPosition = it
            }
            val contentModifier = remember {
                Modifier
                    .weight(9f)
                    .fillMaxWidth()
            }

            when (selectedItemPosition) {
                ORDER_DETAILS_POSITION -> OrderDetails(modifier = contentModifier, onScreenChanged = onScreenChanged)
                EXPERTS_LIST_POSITION -> ExpertsList(modifier = contentModifier, categoryName = categoryName)
            }
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun CategoriesColumn(
    modifier: Modifier,
    selectedItemPosition: Int,
    onClick: (newPosition: Int) -> Unit,
) {
    Column(modifier = modifier) {
        SelectableText(
            modifier = Modifier.fillMaxWidth().pointerHoverIcon(PointerIcon.Hand),
            text = stringResource(Res.string.orders_send_order),
            isSelected = selectedItemPosition == ORDER_DETAILS_POSITION,
            onClick = { onClick(ORDER_DETAILS_POSITION) },
            style = MaterialTheme.typography.subtitle1,
            textColor = MaterialTheme.colors.primary,
            fontWeight = FontWeight.Bold,
        )

        SelectableText(
            modifier = Modifier.fillMaxWidth().pointerHoverIcon(PointerIcon.Hand),
            text = stringResource(Res.string.orders_choose_specialist),
            isSelected = selectedItemPosition == EXPERTS_LIST_POSITION,
            onClick = { onClick(EXPERTS_LIST_POSITION) },
            style = MaterialTheme.typography.subtitle1,
            textColor = MaterialTheme.colors.primary,
            fontWeight = FontWeight.Bold,
        )
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun OrderDetails(
    modifier: Modifier,
    onScreenChanged: (destination: Destinations) -> Unit,
) {
    var text by remember { mutableStateOf("") }

    Column(modifier = modifier) {
        TitleTextComponent(text = stringResource(Res.string.orders_describe_task))

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 200.dp),
            shape = RoundedCornerShape(8.dp),
            value = text,
            onValueChange = { text = it },
            textStyle = MaterialTheme.typography.h6,
            placeholder = { Text(text = stringResource(Res.string.orders_describe_order)) },
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colors.primary,
                placeholderColor = MaterialTheme.colors.primaryVariant,
                backgroundColor = MaterialTheme.colors.onBackground,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
        )

        Spacer(modifier = Modifier.height(24.dp))

        ButtonRedComponent(
            modifier = Modifier.align(Alignment.End),
            text = stringResource(Res.string.orders_send_request),
            onClick = { onScreenChanged(Destinations.OrdersHistory) },
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            modifier = Modifier,
            text = stringResource(Res.string.orders_you_look),
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(backgroundColor = MaterialTheme.colors.onPrimary) {
            UserInfoComponent(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
            )
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun ExpertsList(
    modifier: Modifier,
    categoryName: String,
) {
    Column(modifier = modifier) {
        Text(
            modifier = Modifier,
            text = stringResource(resource = Res.string.orders_specialist_in_category, categoryName),
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold,
        )

        SpecialistsList(modifier = Modifier.padding(top = 16.dp, bottom = 24.dp))
    }
}

@Composable
private fun SpecialistsList(modifier: Modifier = Modifier) {
    val aboutMeText =
        "Приеду и сделаю все что нужно. Ремонт европейской сантехники: унитазы, смесители, душевые кабины, гидромассажные ванны TEUCO, JACUZZI, DURAVIT, Ideai Standart, IDO, GUSTAVSBERG, GROHE, Hansgrohe, APPOLLO. GEBERIT, WISA, VIEGO, REMER, TECE, OLI"
    val phoneNumberText = "8 909 998 73 63"
    val list = listOf(
        SpecialistUiEntity(
            "Кирилл Бородист",
            rating = 4.95,
            yearStartWorking = 2024,
            aboutMe = aboutMeText,
            phoneNumber = phoneNumberText
        ),
        SpecialistUiEntity(
            "Просто Сантехник",
            rating = 5.0,
            yearStartWorking = 2018,
            aboutMe = aboutMeText,
            phoneNumber = phoneNumberText
        ),
        SpecialistUiEntity(
            "Рыжый",
            rating = 1.0,
            yearStartWorking = 1994,
            aboutMe = aboutMeText,
            phoneNumber = phoneNumberText
        ),
        SpecialistUiEntity(
            "Бородист Кирилл",
            rating = 4.85,
            yearStartWorking = 2000,
            aboutMe = aboutMeText,
            phoneNumber = phoneNumberText
        ),
        SpecialistUiEntity(
            "Сантехник с длинным именем и бородой",
            rating = 3.7,
            yearStartWorking = 2012,
            aboutMe = aboutMeText,
            phoneNumber = phoneNumberText
        ),
    )
    LazyColumn(
        modifier = modifier,
    ) {
        items(list.size) { index ->
            SpecialistInfoComponent(specialistEntity = list[index])
            if (index != list.lastIndex) {
                SpacerGrayDefault(modifier = Modifier.padding(top = 12.dp, bottom = 20.dp))
            }
        }
    }
}
