package br.edu.ifal.aluno.arestro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import br.edu.ifal.aluno.arestro.navigation.ArestroNavHost
import br.edu.ifal.aluno.arestro.ui.theme.ARestroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ARestroTheme {
                val navController = rememberNavController()
                ArestroApp {
                    ArestroNavHost(navController)
                }
            }
        }
    }
}

@Composable
fun ArestroApp(
    content: @Composable () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.systemBars),
    ) {
        content()
    }
}