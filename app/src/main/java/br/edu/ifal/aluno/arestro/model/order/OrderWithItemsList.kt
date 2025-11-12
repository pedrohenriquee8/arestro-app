package br.edu.ifal.aluno.arestro.model.order

val orderList = Order(
    userId = 1,
    restaurantId = 1,
    totalPrice = 154.70,
)

val orderItemList = listOf(
    OrderItem(
        orderId = 1,
        foodId = 1,
        quantity = 2,
        price = 49.90
    ),
    OrderItem(
        orderId = 1,
        foodId = 2,
        quantity = 1,
        price = 54.90
    ),
    OrderItem(
        orderId = 2,
        foodId = 6,
        quantity = 3,
        price = 39.90
    )
)