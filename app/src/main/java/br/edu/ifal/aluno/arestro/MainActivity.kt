package br.edu.ifal.aluno.arestro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import br.edu.ifal.aluno.arestro.navigation.ArestroNavHost
import br.edu.ifal.aluno.arestro.ui.theme.ARestroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ARestroTheme {
                Surface(modifier = Modifier.fillMaxSize()) {

                    val navController = rememberNavController()

                    ArestroNavHost(navController = navController)
                }
            }
        }
    }
}
