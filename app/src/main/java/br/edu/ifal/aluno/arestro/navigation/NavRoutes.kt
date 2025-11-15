package br.edu.ifal.aluno.arestro.navigation

sealed class NavRoutes(val route: String) {
    object RestaurantList : NavRoutes("restaurant_list")
    object RestaurantDetail : NavRoutes("restaurant_detail/{restaurantId}") {
        fun createRoute(restaurantId: Int) = "restaurant_detail/$restaurantId"
    }
}