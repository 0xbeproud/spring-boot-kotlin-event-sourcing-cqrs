package com.nnobs.api

import com.nnobs.service.UserQueryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserQueryController(
        private val userQueryService: UserQueryService
) {
    @GetMapping("/{id}")
    fun listEvents(@PathVariable("id") id: String): List<Any> =
            this.userQueryService.listEvents(id)
}