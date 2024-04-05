package presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun UserInfoComponent(modifier: Modifier = Modifier) {
    Row(modifier = modifier.padding(vertical = 16.dp)) {
        Image(
            modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .clip(RoundedCornerShape(20.dp)),
            contentScale = ContentScale.Crop,
            painter = painterResource(DrawableResource("composeResources/drawable/account_photo_mock.JPG")),
            contentDescription = null,
        )

        Column(modifier = Modifier.padding(horizontal = 12.dp)) {
            Text(
                text = "Кирилл Битков",
                style = MaterialTheme.typography.subtitle2,
                color = MaterialTheme.colors.primaryVariant,
                fontWeight = FontWeight.Bold,
            )

            Text(
                text = "+7 969 130 12 10",
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.primaryVariant,
            )
        }
    }
}