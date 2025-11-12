package br.edu.ifal.aluno.arestro.components.base.searchBar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Mic
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SearchBarComponent(
    onSearch: (String) -> Unit,
    onVoiceInputClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var searchText by remember { mutableStateOf("") }

    val containerColor = Color(0xFFF0F0F0)
    val borderColor = Color.LightGray

    OutlinedTextField(
        value = searchText,
        onValueChange = {
            searchText = it
        },
        placeholder = {
            Text("Search for food, restaurants...")
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Pesquisar por comidas ou restaurantes",
                modifier = Modifier.size(24.dp),
                tint = Color.Gray
            )
        },
        trailingIcon = {
            IconButton(onClick = onVoiceInputClick) {
                Icon(
                    imageVector = Icons.Outlined.Mic,
                    contentDescription = "Pesquisar por voz",
                    modifier = Modifier.size(24.dp),
                    tint = Color.Gray
                )
            }
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),

        shape = RoundedCornerShape(8.dp),

        colors = TextFieldDefaults.colors(
            focusedContainerColor = containerColor,
            unfocusedContainerColor = containerColor,
            disabledContainerColor = containerColor,
            cursorColor = Color.DarkGray,
            focusedIndicatorColor = borderColor,
            unfocusedIndicatorColor = borderColor,
            disabledIndicatorColor = borderColor,
            focusedLeadingIconColor = Color.Gray,
            unfocusedLeadingIconColor = Color.Gray,
            focusedPlaceholderColor = Color.Gray,
            unfocusedPlaceholderColor = Color.Gray,
        ),

        singleLine = true
    )
}