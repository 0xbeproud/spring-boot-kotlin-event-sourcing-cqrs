package com.nnobs.api

import com.nnobs.dto.OrderCreateDto
import com.nnobs.dto.UserCreateDto
import com.nnobs.service.UserCommandService
import org.springframework.web.bind.annotation.*
import java.util.concurrent.CompletableFuture

@RestController
@RequestMapping("/users")
class UserCommandController(
        private val userCommandService: UserCommandService
) {
    @PostMapping
    fun createUser(@RequestBody dto: UserCreateDto): CompletableFuture<String> =
            userCommandService.createUser(dto)

    @PostMapping("{userId}/orders")
    fun createOrder(
            @PathVariable("userId") userId: String,
            @RequestBody dto: OrderCreateDto): CompletableFuture<String> =
            this.userCommandService.createOrder(userId, dto)
}