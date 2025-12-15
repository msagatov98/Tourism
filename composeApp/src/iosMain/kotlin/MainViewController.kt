import androidx.compose.ui.window.ComposeUIViewController
import org.example.project.app.presentation.App
import org.example.project.app.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = { initKoin() },
    content = { App() },
)