package br.edu.ifal.aluno.arestro

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import br.edu.ifal.aluno.arestro.db.DatabaseHelper
import br.edu.ifal.aluno.arestro.model.contact.Contact
import br.edu.ifal.aluno.arestro.navigation.ArestroNavHost
import br.edu.ifal.aluno.arestro.ui.theme.ARestroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val dao = DatabaseHelper.getInstance(context = LocalContext.current).contactDao()
    var contacts by remember { mutableStateOf(emptyList<Contact>()) }

    LaunchedEffect(Unit) {
        contacts = dao.findAllByUserId(1)
        Log.d("ArestroApp", "Contatos carregados: $contacts")
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        content()
    }
}