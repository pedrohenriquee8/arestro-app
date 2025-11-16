package br.edu.ifal.aluno.arestro.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import br.edu.ifal.aluno.arestro.model.order.Order
import br.edu.ifal.aluno.arestro.model.order.OrderItem
import br.edu.ifal.aluno.arestro.model.order.OrderWithItems

@Dao
interface OrderDao {
    @Query("SELECT * FROM `order` WHERE userId = :userId")
    suspend fun findOrdersByUserId(userId: Int): List<OrderWithItems?>

    @Insert
    suspend fun create(order: Order): Long

    @Insert
    suspend fun createOrderItem(item: OrderItem)

    @Transaction
    suspend fun createOrderWithItems(order: Order, items: List<OrderItem>) {
        val orderId = create(order)
        val itemsWithOrderId = items.map { it.copy(orderId = orderId.toInt()) }
        itemsWithOrderId.forEach { createOrderItem(it) }
    }
}