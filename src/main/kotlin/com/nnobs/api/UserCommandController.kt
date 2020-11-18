package com.nnobs.api

import com.nnobs.dto.UserCreateDto
import com.nnobs.service.UserCommandService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.CompletableFuture

@RestController
@RequestMapping("/users")
class UserCommandController(
        private val userCommandService: UserCommandService
) {
    @PostMapping
    fun createUser(@RequestBody dto: UserCreateDto): CompletableFuture<String>
            = userCommandService.createUser(dto)
}