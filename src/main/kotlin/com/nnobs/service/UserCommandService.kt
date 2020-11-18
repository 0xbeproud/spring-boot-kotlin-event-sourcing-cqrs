package com.nnobs.service

import com.nnobs.command.order.OrderCreateCommand
import com.nnobs.command.user.UserCreateCommand
import com.nnobs.domain.aggregate.UserAggregate
import com.nnobs.dto.OrderCreateDto
import com.nnobs.dto.UserCreateDto
import org.axonframework.commandhandling.gateway.CommandGateway
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*
import java.util.concurrent.CompletableFuture

@Service
class UserCommandService(
        private val commandGateway: CommandGateway
) {
    private final val logger: Logger = LoggerFactory.getLogger(UserCommandService::class.java)

    fun createUser(dto: UserCreateDto): CompletableFuture<String> {
        val userId = UUID.randomUUID().toString()
        logger.debug("createUser id: {}", userId)
        return this.commandGateway.send(
                UserCreateCommand(
                        userId,
                        dto.email
                )
        )
    }

    fun createOrder(userId: String, dto: OrderCreateDto): CompletableFuture<String> {
        logger.debug("userId: {}", userId)
        return commandGateway.send(
                OrderCreateCommand(
                        userId,
                        dto.name,
                        dto.price
                )
        )
    }
}