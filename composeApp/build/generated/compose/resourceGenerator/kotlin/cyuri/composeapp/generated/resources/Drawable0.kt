@file:OptIn(org.jetbrains.compose.resources.InternalResourceApi::class)

package cyuri.composeapp.generated.resources

import kotlin.OptIn
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi

@ExperimentalResourceApi
private object Drawable0 {
  public val account_photo_mock: DrawableResource by 
      lazy { init_account_photo_mock() }

  public val category_mock_1: DrawableResource by 
      lazy { init_category_mock_1() }

  public val category_mock_2: DrawableResource by 
      lazy { init_category_mock_2() }

  public val ic_green_ok: DrawableResource by 
      lazy { init_ic_green_ok() }

  public val ic_star: DrawableResource by 
      lazy { init_ic_star() }

  public val spicialist_photo_mock: DrawableResource by 
      lazy { init_spicialist_photo_mock() }
}

@ExperimentalResourceApi
internal val Res.drawable.account_photo_mock: DrawableResource
  get() = Drawable0.account_photo_mock

@ExperimentalResourceApi
private fun init_account_photo_mock(): DrawableResource =
    org.jetbrains.compose.resources.DrawableResource(
  "drawable:account_photo_mock",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(), "drawable/account_photo_mock.jpg"),
    )
)

@ExperimentalResourceApi
internal val Res.drawable.category_mock_1: DrawableResource
  get() = Drawable0.category_mock_1

@ExperimentalResourceApi
private fun init_category_mock_1(): DrawableResource =
    org.jetbrains.compose.resources.DrawableResource(
  "drawable:category_mock_1",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(), "drawable/category_mock_1.png"),
    )
)

@ExperimentalResourceApi
internal val Res.drawable.category_mock_2: DrawableResource
  get() = Drawable0.category_mock_2

@ExperimentalResourceApi
private fun init_category_mock_2(): DrawableResource =
    org.jetbrains.compose.resources.DrawableResource(
  "drawable:category_mock_2",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(), "drawable/category_mock_2.png"),
    )
)

@ExperimentalResourceApi
internal val Res.drawable.ic_green_ok: DrawableResource
  get() = Drawable0.ic_green_ok

@ExperimentalResourceApi
private fun init_ic_green_ok(): DrawableResource = org.jetbrains.compose.resources.DrawableResource(
  "drawable:ic_green_ok",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(), "drawable/ic_green_ok.png"),
    )
)

@ExperimentalResourceApi
internal val Res.drawable.ic_star: DrawableResource
  get() = Drawable0.ic_star

@ExperimentalResourceApi
private fun init_ic_star(): DrawableResource = org.jetbrains.compose.resources.DrawableResource(
  "drawable:ic_star",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(), "drawable/ic_star.png"),
    )
)

@ExperimentalResourceApi
internal val Res.drawable.spicialist_photo_mock: DrawableResource
  get() = Drawable0.spicialist_photo_mock

@ExperimentalResourceApi
private fun init_spicialist_photo_mock(): DrawableResource =
    org.jetbrains.compose.resources.DrawableResource(
  "drawable:spicialist_photo_mock",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(), "drawable/spicialist_photo_mock.jpg"),
    )
)
