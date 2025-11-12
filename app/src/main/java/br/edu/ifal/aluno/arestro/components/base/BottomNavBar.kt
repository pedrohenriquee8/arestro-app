package br.edu.ifal.aluno.arestro.components.base

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import br.edu.ifal.aluno.arestro.model.BottomNavBarItem
import br.edu.ifal.aluno.arestro.ui.theme.Gray10
import br.edu.ifal.aluno.arestro.ui.theme.Gray50
import br.edu.ifal.aluno.arestro.ui.theme.Green90

@Composable
fun BottomNavBar(
    selectedItem: BottomNavBarItem,
    onItemChanged: (BottomNavBarItem) -> Unit,
) {
    NavigationBar(
        containerColor = Color.White
    ) {
        bottomNavBarItems.forEach { item ->
            val isSelected = selectedItem.label == item.label

            NavigationBarItem(
                selected = isSelected,
                onClick = { onItemChanged(item) },
                icon = {
                    Icon(
                        item.icon,
                        contentDescription = item.label + " icon"
                    )
                },
                label = {
                    Text(
                        item.label,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.SemiBold,
                    )
                },
                colors = NavigationBarItemColors(
                    selectedIconColor = Green90,
                    selectedTextColor = Green90,
                    selectedIndicatorColor = Color.Transparent,
                    unselectedIconColor = Gray50,
                    unselectedTextColor = Gray50,
                    disabledIconColor = Gray10,
                    disabledTextColor = Gray10,
                )
            )
        }
    }

}