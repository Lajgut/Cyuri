package presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import presentation.components.HeaderComponent
import presentation.components.SpacerGrayDefault
import presentation.components.home.AboutTextComponent
import presentation.components.home.MainCategoryComponent
import presentation.navigation.Destinations

@Composable
fun HomeScreen(
    modifier: Modifier,
    onScreenChanged: (destination: Destinations) -> Unit,
) {
    val isScrolled = remember { mutableStateOf(false) }

    Column {
        HeaderComponent(
            modifier = modifier,
            onLogoClick = { onScreenChanged(Destinations.Home) },
            onAccountClick = { onScreenChanged(Destinations.Account) },
            onOrdersClick = { onScreenChanged(Destinations.OrdersHistory) },
        )
        SpacerGrayDefault(shouldHide = isScrolled.value)
        MainContent(
            modifier = modifier,
            isScrolled = isScrolled,
            onScreenChanged = onScreenChanged,
        )
    }
}

@Composable
fun MainContent(
    modifier: Modifier,
    isScrolled: MutableState<Boolean>,
    onScreenChanged: (destination: Destinations) -> Unit,
) {
    val scrollState = rememberScrollState()
    isScrolled.value = scrollState.canScrollBackward

    Column(
        modifier = Modifier.verticalScroll(scrollState),
    ) {
        Spacer(Modifier.height(40.dp))
        Text(
            modifier = modifier,
            text = "Доверьте ваши проблемы\nспециалисту",
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.primaryVariant,
            fontWeight = FontWeight.Bold,
        )
        Spacer(Modifier.height(30.dp))
        SearchComponent(modifier = modifier)
        Spacer(Modifier.height(40.dp))
        Caterories(modifier = modifier, onScreenChanged = onScreenChanged)
        Spacer(Modifier.height(30.dp))
        AboutUs(modifier = modifier)
    }
}

@Composable
fun SearchComponent(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }

    Row(
        modifier = modifier.height(55.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        TextField(
            modifier = Modifier
                .weight(4.6f)
                .fillMaxHeight(),
            shape = RoundedCornerShape(8.dp),
            value = text,
            onValueChange = { text = it },
            textStyle = MaterialTheme.typography.h6,
            placeholder = { Text("С чем вам нужна помощь?") },
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colors.primary,
                placeholderColor = MaterialTheme.colors.primaryVariant,
                backgroundColor = MaterialTheme.colors.onBackground,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
        )

        Button(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.secondary
            ),
            onClick = {},
        ) {
            Text(
                text = "Поиск",
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onPrimary,
            )
        }
    }
}

@Composable
private fun Caterories(modifier: Modifier = Modifier, onScreenChanged: (destination: Destinations) -> Unit) {
    val list = listOf(
        "Experienced IT specialists can help you with any computer problem",
        "Helps around the house",
        "Lorem ipsum Lorem ipsum Lorem ipsum",
        "Lorem ipsum",
        "Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum",
        "Lorem ipsum Lorem ipsum",
    )

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        MainCategoryComponent(modifier = Modifier.clickable { onScreenChanged(Destinations.Order) }, title = list[0], imgRes = "composeResources/drawable/category_mock_1.png")
        MainCategoryComponent(modifier = Modifier.clickable { onScreenChanged(Destinations.Order) }, title = list[1], imgRes = "composeResources/drawable/category_mock_2.png")
        MainCategoryComponent(modifier = Modifier.clickable { onScreenChanged(Destinations.Order) }, title = list[2], imgRes = "composeResources/drawable/category_mock_1.png")
        MainCategoryComponent(modifier = Modifier.clickable { onScreenChanged(Destinations.Order) }, title = list[3], imgRes = "composeResources/drawable/category_mock_2.png")
    }

    Spacer(Modifier.height(12.dp))

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        MainCategoryComponent(modifier = Modifier.clickable { onScreenChanged(Destinations.Order) }, title = list[3], imgRes = "composeResources/drawable/category_mock_1.png")
        MainCategoryComponent(modifier = Modifier.clickable { onScreenChanged(Destinations.Order) }, title = list[4], imgRes = "composeResources/drawable/category_mock_1.png")
        MainCategoryComponent(modifier = Modifier.clickable { onScreenChanged(Destinations.Order) }, title = list[2], imgRes = "composeResources/drawable/category_mock_2.png")
        MainCategoryComponent(modifier = Modifier.clickable { onScreenChanged(Destinations.Order) }, title = list[5], imgRes = "composeResources/drawable/category_mock_1.png")
    }
}

@Composable
private fun AboutUs(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .background(color = MaterialTheme.colors.onBackground)
            .fillMaxWidth()
            .padding(vertical = 20.dp)
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column {
                AboutTextComponent(text = "О нас")
                //AboutTextComponent(text = getString(Res.strings.app_name))
                AboutTextComponent(text = "Пользовательское соглашение")
                AboutTextComponent(text = "Все права защищены, LTD LTP and TD, 2020")
            }

            Column {
                AboutTextComponent(text = "Контакты")
                Text(
                    text = "поддержка:\n+7 999 00 88",
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.primary,
                )
            }
        }
    }
}