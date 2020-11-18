package com.nnobs.domain.aggregate

import com.nnobs.command.order.OrderCreateCommand
import com.nnobs.command.user.UserCreateCommand
import com.nnobs.event.order.OrderCreateEvent
import com.nnobs.event.user.UserCreateEvent
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle
import org.axonframework.spring.stereotype.Aggregate
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException

@Aggregate
class UserAggregate {

    private final val logger: Logger = LoggerFactory.getLogger(UserAggregate::class.java)

    @AggregateIdentifier
    private lateinit var id: String
    private var email: String = ""
    private var point: Int = 0

    constructor()

    @CommandHandler
    constructor(command: UserCreateCommand) {
        logger.debug("user create command handler: {}", command)
        this.id = command.id
        AggregateLifecycle.apply(
                UserCreateEvent(
                        command.id,
                        command.email,
                        1000, // 회원가입 1000포인트
                )
        )
    }

    @EventSourcingHandler
    fun on(event: UserCreateEvent) {
        logger.debug("user create event handler: {}", event)
        this.id = event.id
        this.email = event.email
        this.point = event.point
    }

    @CommandHandler
    fun on(command: OrderCreateCommand) {
        logger.debug("order create command handler: {}", command)
        if(command.price <= 0)
            throw IllegalArgumentException("price > 0")
        if(this.point < command.price)
            throw IllegalStateException("point 부족")

        AggregateLifecycle.apply(
                OrderCreateEvent(
                        command.id,
                        command.name,
                        command.price
                )
        )
    }

    @EventSourcingHandler
    fun on(event: OrderCreateEvent) {
        logger.debug("order create event handler: {}", event)
        this.point -= event.price
    }
}