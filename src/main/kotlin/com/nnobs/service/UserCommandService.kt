package com.nnobs.service

import com.nnobs.command.user.UserCreateCommand
import com.nnobs.dto.UserCreateDto
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.stereotype.Service
import java.util.*
import java.util.concurrent.CompletableFuture

@Service
class UserCommandService(
        private val commandGateway: CommandGateway
) {
    fun createUser(dto: UserCreateDto): CompletableFuture<String> {
        return this.commandGateway.send(
                UserCreateCommand(
                        UUID.randomUUID().toString(),
                        dto.email
                )
        )
    }
}