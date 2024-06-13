package presentation.components.orders

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import cyuri.composeapp.generated.resources.Res
import cyuri.composeapp.generated.resources.ic_green_ok
import cyuri.composeapp.generated.resources.ic_star
import cyuri.composeapp.generated.resources.spicialist_photo_mock
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import presentation.orders.SpecialistUiEntity

@Composable
fun SpecialistInfoComponent(
    modifier: Modifier = Modifier,
    specialistEntity: SpecialistUiEntity,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        MainInfoRow(specialistEntity = specialistEntity)
        UserCheckedRow()
        Text(
            text = specialistEntity.aboutMe,
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.primary,
        )
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun MainInfoRow(specialistEntity: SpecialistUiEntity) {
    Row(
        modifier = Modifier.height(110.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        Image(
            modifier = Modifier
                .fillMaxHeight()
                .width(72.dp)
                .clip(RoundedCornerShape(4.dp)),
            contentScale = ContentScale.Crop,
            painter = painterResource(Res.drawable.spicialist_photo_mock),
            contentDescription = null,
        )

        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Column {
                Text(
                    text = specialistEntity.name,
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.primary,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = "на сайте с ${specialistEntity.yearStartWorking} года",
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.primary,
                )
            }

            Text(
                text = specialistEntity.phoneNumber,
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold,
            )

            RatingRow(
                modifier = Modifier.padding(bottom = 2.dp),
                rating = specialistEntity.rating,
            )
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun RatingRow(
    modifier: Modifier = Modifier,
    rating: Double,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier.size(16.dp),
            painter = painterResource(Res.drawable.ic_star),
            contentDescription = null,
        )

        Text(
            text = rating.toString(),
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.Bold,
        )
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun UserCheckedRow(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier.size(16.dp),
            painter = painterResource(Res.drawable.ic_green_ok),
            contentDescription = null,
        )

        Text(
            text = "Проверенный специалист",
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.Bold,
        )
    }
}