package br.edu.ifal.aluno.arestro.main.screens

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import br.edu.ifal.aluno.arestro.main.model.BottomNavBarItem
import br.edu.ifal.aluno.arestro.ui.theme.Green90
import br.edu.ifal.aluno.arestro.main.model.AppBarItem

val bottomNavBarItems = listOf(
    BottomNavBarItem.HomeNavBarItem,
    BottomNavBarItem.SearchNavBarItem,
    BottomNavBarItem.CartNavBarItem,
)

@Composable
fun HomeScreen(onNavigateFromExploreToDetail: () -> Unit = {}, modifier: Modifier = Modifier) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    var selectedItem by remember {
        val item = bottomNavBarItems.first()
        mutableStateOf(item)
    }

    val pageState = rememberPagerState {
        bottomNavBarItems.size
    }

    LaunchedEffect(selectedItem) {
        val currentIndex = bottomNavBarItems.indexOf(selectedItem)
        pageState.animateScrollToPage(currentIndex)
    }

    LaunchedEffect(pageState.targetPage) {
        selectedItem = bottomNavBarItems[pageState.targetPage]
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {}
    ) {
        Scaffold(
            topBar = {
                AppBarItem(
                    scope = scope,
                    drawerState = drawerState,
                    onAvatarClick = {}
                )
            },

            bottomBar = {
                BottomNavBar(
                    selectedItem = selectedItem,
                    onItemChanged = { item ->
                        selectedItem = item
                    }
                )
            }) { innerPadding ->
            Surface(modifier.padding(innerPadding)) {
                HorizontalPager(pageState, userScrollEnabled = false) { page ->
                    val item = bottomNavBarItems[page]
                    when (item) {
                        BottomNavBarItem.HomeNavBarItem -> DashboardScreen()
                        BottomNavBarItem.SearchNavBarItem -> SearchScreen()
                        BottomNavBarItem.CartNavBarItem -> CartScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun BottomNavBar(
    modifier: Modifier = Modifier,
    selectedItem: BottomNavBarItem,
    onItemChanged: (BottomNavBarItem) -> Unit,
) {
    NavigationBar(
        containerColor = Color.White
    ) {
        bottomNavBarItems.forEach { item ->
            NavigationBarItem(
                selected = selectedItem.label == item.label, onClick = {
                    Log.i("TAG", item.label)
                    onItemChanged(item)
                }, icon = {
                    Icon(
                        item.icon, contentDescription = ""
                    )
                }, label = { Text(item.label) }, colors = NavigationBarItemColors(
                    selectedIconColor = Green90,
                    selectedTextColor = Green90,
                    selectedIndicatorColor = Color.Transparent,
                    unselectedIconColor = DarkGray,
                    unselectedTextColor = DarkGray,
                    disabledIconColor = LightGray,
                    disabledTextColor = LightGray
                )
            )
        }
    }

}