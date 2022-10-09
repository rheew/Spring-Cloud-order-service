package com.example.orderservice.service

import com.example.orderservice.domain.Order
import com.example.orderservice.domain.OrderRequest
import com.example.orderservice.domain.OrderResponse
import com.example.orderservice.repository.OrderRepository
import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val modelMapper: ModelMapper
) {
    fun createOrder(orderRequest: OrderRequest): OrderResponse {

        modelMapper.configuration.setMatchingStrategy(MatchingStrategies.STRICT)
        val order = modelMapper.map(orderRequest, Order::class.java)

        order.orderId = UUID.randomUUID().toString()
        order.totalPrice = order.qty?.times(order.unitPrice!!)

        orderRepository.save(order)

        return modelMapper.map(order, OrderResponse::class.java)
    }

    fun getOrders(userId: String): List<OrderResponse> {
        return orderRepository.findByUserId(userId).stream()
            .map {
                order -> modelMapper.map(order, OrderResponse::class.java)
            }
            .collect(Collectors.toList())
    }

    fun getOrder(orderId: String): OrderResponse {
        return orderRepository.findByOrderId(orderId).stream()
            .map { order ->  modelMapper.map(order, OrderResponse::class.java)}
            .findAny().orElseThrow()
    }
}