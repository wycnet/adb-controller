import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.LeftPanel
import ui.RightPanel
import ui.leftPanelBgColor

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        Row {
            Surface(Modifier.weight(1f).fillMaxHeight(), color = leftPanelBgColor) {
                LeftPanel()
            }
            Surface(Modifier.weight(2f).fillMaxHeight()) {
                RightPanel()
            }
        }

    }
}