package br.edu.ifal.aluno.arestro.components.base

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import br.edu.ifal.aluno.arestro.model.BottomNavBarItem
import br.edu.ifal.aluno.arestro.screens.CartScreen
import br.edu.ifal.aluno.arestro.screens.HomeScreen
import br.edu.ifal.aluno.arestro.screens.SearchScreen

val bottomNavBarItems = listOf(
    BottomNavBarItem.HomeNavBarItem,
    BottomNavBarItem.SearchNavBarItem,
    BottomNavBarItem.CartNavBarItem,
)

@Composable
fun Layout(
    showAppBar: Boolean = false,
    showBottomBar: Boolean = false,
    navController: NavController,
) {
    var selectedItem by remember { mutableStateOf(bottomNavBarItems.first()) }
    val pageState = rememberPagerState { bottomNavBarItems.size }

    LaunchedEffect(selectedItem) {
        val currentIndex = bottomNavBarItems.indexOf(selectedItem)
        pageState.animateScrollToPage(currentIndex)
    }

    LaunchedEffect(pageState.targetPage) {
        selectedItem = bottomNavBarItems[pageState.targetPage]
    }

    Scaffold(
        topBar = {
            if (showAppBar) {
                AppBar()
            }
        },
        bottomBar = {
            if (showBottomBar) {
                BottomNavBar(
                    selectedItem = selectedItem,
                    onItemChanged = { item ->
                        selectedItem = item
                    }
                )
            }
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .windowInsetsPadding(WindowInsets.systemBars)
        ) {
            HorizontalPager(pageState) { page ->
                val item = bottomNavBarItems[page]
                when (item) {
                    BottomNavBarItem.HomeNavBarItem -> HomeScreen()
                    BottomNavBarItem.SearchNavBarItem -> SearchScreen()
                    BottomNavBarItem.CartNavBarItem -> CartScreen()
                }
            }
        }
    }
}