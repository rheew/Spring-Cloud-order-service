package com.example.orderservice

import org.modelmapper.ModelMapper
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class OrderServiceApplication {
    @Bean
    fun modelMapper(): ModelMapper {
        return ModelMapper()
    }
}

@Bean
fun main(args: Array<String>) {
    runApplication<OrderServiceApplication>(*args)
}
