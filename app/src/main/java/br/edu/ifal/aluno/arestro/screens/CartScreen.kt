package br.edu.ifal.aluno.arestro.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import br.edu.ifal.aluno.arestro.ui.theme.Typography

@Composable
fun CartScreen() {
    Text(
        text = "Welcome to ARestro! This is the cart screen.",
        style = Typography.headlineSmall,
    )
}