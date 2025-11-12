package br.edu.ifal.aluno.arestro.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import br.edu.ifal.aluno.arestro.ui.theme.Typography

@Composable
fun OnBoardingScreen(
    onNavigateToHomePage: () -> Unit = {}
) {
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            "Welcome to ARestro! This is the onboarding screen.",
            style = Typography.headlineSmall,
            textAlign = TextAlign.Center
        )
        Button(
            onClick = onNavigateToHomePage
        ) {
            Text(text = "Get Started")
        }
    }
}