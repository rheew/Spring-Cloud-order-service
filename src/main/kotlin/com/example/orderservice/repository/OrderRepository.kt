package com.example.orderservice.repository

import com.example.orderservice.domain.Order
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface OrderRepository : JpaRepository<Order, Long> {
    fun findByOrderId(orderId: String): Optional<Order>
    fun findByUserId(userId: String): List<Order>
}