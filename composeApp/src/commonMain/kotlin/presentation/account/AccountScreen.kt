package presentation.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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

@Composable
fun AccountScreen() {
    Column {
        Text(
            text = "Ваш профиль",
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.Bold,
        )

        ProfileContent(
            modifier = Modifier.background(color = MaterialTheme.colors.background),
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
                color = MaterialTheme.colors.secondary,
            )

            Text(
                text = "+7 969 130 12 10",
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.secondary,
            )
        }
    }
}
