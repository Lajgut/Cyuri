package presentation.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun MainCategoryComponent(
    modifier: Modifier = Modifier,
    title: String,
    imgRes: DrawableResource,
) {
    Column(
        modifier = modifier
            .width(225.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.FillBounds,
            painter = painterResource(imgRes),
            contentDescription = null,
        )

        Text(
            text = title,
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.primary,
        )
    }
}