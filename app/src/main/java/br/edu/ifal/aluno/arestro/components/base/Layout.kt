package br.edu.ifal.aluno.arestro.components.base

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Layout(
    showAppBar: Boolean = false,
    content: @Composable () -> Unit
) {
    Scaffold(
        topBar = {
            if (showAppBar) {
                AppBar()
            }
        },
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .windowInsetsPadding(WindowInsets.systemBars)
        ) {
            content()
        }
    }
}