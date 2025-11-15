package br.edu.ifal.aluno.arestro.components.base

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchCard(
    onSearchClick: (String) -> Unit = {},
    onAdvancedSearchClick: () -> Unit = {}
) {
    var query by remember { mutableStateOf("") }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Find a Restaurant nearby",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                placeholder = { Text("Search for Restaurant") },
                leadingIcon = {
                    Icon(Icons.Default.Search, contentDescription = "Search Icon")
                },
                trailingIcon = {
                    Icon(Icons.Default.Mic, contentDescription = "Voice Search")
                },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = { onSearchClick(query) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00A651)), // verde
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "Search", color = Color.White, fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Advanced Search",
                color = Color.Gray,
                fontSize = 14.sp,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable { onAdvancedSearchClick() }
            )
        }
    }
}

