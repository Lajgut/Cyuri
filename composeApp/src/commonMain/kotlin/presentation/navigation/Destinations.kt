package presentation.navigation

sealed class Destinations(route: String) {
    data object Home: Destinations("home")
    data object Account: Destinations("account")
    data object Orders: Destinations("orders")
}