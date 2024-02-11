import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import presentation.main.MainScreen
import theme.AppTheme

@Composable
fun App() {
    
    AppTheme {
        val webModifier = Modifier
            .padding(start = 330.dp, end = 330.dp)

        MainScreen(webModifier)
    }
}
