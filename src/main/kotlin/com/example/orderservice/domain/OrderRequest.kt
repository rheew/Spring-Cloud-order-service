package com.example.orderservice.domain

class OrderRequest {
    var userId: String? = null
    var productId: String? = null
    var qty: Int? = null
    var unitPrice: Int? = null
}