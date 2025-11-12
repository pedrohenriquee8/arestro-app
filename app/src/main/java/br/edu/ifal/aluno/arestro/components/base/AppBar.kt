package br.edu.ifal.aluno.arestro.components.base

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.edu.ifal.aluno.arestro.R

@Composable
fun AppBar() {
    Surface(
        shadowElevation = 8.dp,
        color = Color.White,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    painter = painterResource(R.drawable.menu),
                    contentDescription = "Menu Icon",
                )
            }
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "ARestro logo",
            )
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "User avatar",
                    tint = Color(0xFF37474F),
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}