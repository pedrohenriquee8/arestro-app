package br.edu.ifal.aluno.arestro.model.order

val orderWithItemsList = listOf<OrderWithItems>(
    OrderWithItems(
        order = Order(
            userId = 1,
            restaurantId = 1,
            totalPrice = 154.70,
        ),
        items = listOf<OrderItem>(
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
            )
        )
    ),
    OrderWithItems(
        order = Order(
            userId = 1,
            restaurantId = 2,
            totalPrice = 89.50,
        ),
        items = listOf<OrderItem>(
            OrderItem(
                orderId = 2,
                foodId = 3,
                quantity = 1,
                price = 29.90
            ),
            OrderItem(
                orderId = 2,
                foodId = 4,
                quantity = 2,
                price = 29.80
            )
        )
    )
)