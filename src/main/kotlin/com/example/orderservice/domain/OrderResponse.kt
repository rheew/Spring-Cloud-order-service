package com.example.orderservice.domain

import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDate

@JsonInclude(JsonInclude.Include.NON_NULL)
class OrderResponse {
    var productId: String? = null
    var qty: Int? = null
    var unitPrice: Int? = null
    var totalPrice: Int? = null
    var createdAt: LocalDate? = null
    var orderId: String? = null
}