package com.example.orderservice.controller

import com.example.orderservice.domain.OrderRequest
import com.example.orderservice.domain.OrderResponse
import com.example.orderservice.service.OrderService
import org.springframework.core.env.Environment
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/order-service")
class OrderController(
    private val orderService: OrderService,
    private val env: Environment
) {

    @GetMapping("/health-check")
    fun status(): String? {
        return "It's Working in UserService" + env.getProperty("local.server.port")
    }

    @PostMapping("/order")
    fun createOrder(@RequestBody req: OrderRequest): ResponseEntity.BodyBuilder {
        orderService.createOrder(req)
        return ResponseEntity.status(HttpStatus.CREATED)
    }

    @GetMapping("/{userId}/orders")
    fun getOrders(@PathVariable userId: String): ResponseEntity<List<OrderResponse>> {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrders(userId))
    }

    @GetMapping("/{orderId}/order")
    fun getOrder(@PathVariable orderId: String): ResponseEntity<OrderResponse> {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrder(orderId))
    }
}