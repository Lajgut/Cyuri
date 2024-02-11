
package presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import components.main.AboutTextComponent
import components.main.MainCategoryComponent

@Composable
fun MainScreen(modifier: Modifier) {

    val isScrolled = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colors.background),
        ) {
        HeaderRow(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp)
        )
            Spacer(
                modifier = Modifier
                    .height(0.5.dp)
                    .fillMaxWidth()
                    .alpha(if (isScrolled.value) 0.2f else 0f)
                    .background(color = MaterialTheme.colors.primaryVariant),
                )
            MainContent(
                defaultPaddingModifier = modifier,
                isScrolled = isScrolled,
                )
    }
}

@Composable
fun HeaderRow(
    modifier: Modifier = Modifier,
    ) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Cyuri.ru",
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.secondary,
            fontWeight = FontWeight.Bold,
            )
        Text(
            text = "Account",
            style = MaterialTheme.typography.subtitle1
        )
    }
}

@Composable
fun MainContent(
    defaultPaddingModifier: Modifier,
    isScrolled: MutableState<Boolean>,
    ) {
    val scrollState = rememberScrollState()
    isScrolled.value = scrollState.canScrollBackward

    Column(
        modifier = Modifier.verticalScroll(scrollState),
        ) {
        Text(
            modifier = defaultPaddingModifier.padding(top = 40.dp),
            text = "Entrust your problem\nto a professional",
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.primaryVariant,
            fontWeight = FontWeight.Bold,
            )
            SearchComponent(modifier = defaultPaddingModifier.padding(top = 30.dp, bottom = 40.dp))
            Caterories(modifier = defaultPaddingModifier.padding(bottom = 30.dp))
            AboutUs(
                modifier = Modifier
                    .background(color = MaterialTheme.colors.onBackground)
                    .fillMaxWidth()
                    .padding(horizontal = 330.dp, vertical = 20.dp)
            )
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
            placeholder = { Text("What kind of job are you need to do?") },
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
                text = "Search",
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onPrimary,
                )
        }
    }
}

@Composable
private fun Caterories(modifier: Modifier = Modifier) {
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
        MainCategoryComponent(title = list[0], imgRes = "category_mock_1.jpeg")
            MainCategoryComponent(title = list[1], imgRes = "category_mock_2.jpg")
            MainCategoryComponent(title = list[2], imgRes = "category_mock_1.jpeg")
            MainCategoryComponent(title = list[3], imgRes = "category_mock_2.jpg")
    }

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        ) {
        MainCategoryComponent(title = list[3], imgRes = "category_mock_1.jpeg")
            MainCategoryComponent(title = list[4], imgRes = "category_mock_1.jpeg")
            MainCategoryComponent(title = list[2], imgRes = "category_mock_2.jpg")
            MainCategoryComponent(title = list[5], imgRes = "category_mock_1.jpeg")
    }
}

@Composable
private fun AboutUs(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            AboutTextComponent(text = "About us")
            //AboutTextComponent(text = getString(Res.strings.app_name))
            AboutTextComponent(text = "Terms of use")
            AboutTextComponent(text = "All right reserved, LTD LTP and TD, 2020")
        }

        Column {
            AboutTextComponent(text = "Our address")
            Text(
                text = "support:\n+7 999 00 88",
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.primary,
                )
        }
    }
}