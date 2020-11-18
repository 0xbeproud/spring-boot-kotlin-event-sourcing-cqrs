package com.nnobs.domain.aggregate

import com.nnobs.command.user.UserCreateCommand
import com.nnobs.event.user.UserCreateEvent
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle
import org.axonframework.spring.stereotype.Aggregate
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Aggregate
class UserAggregate {

    private final val logger: Logger = LoggerFactory.getLogger(UserAggregate::class.java)

    @AggregateIdentifier
    var id: String = ""
    var email: String = ""

    constructor()

    @CommandHandler
    constructor(command: UserCreateCommand) {
        logger.debug("command handler: {}", command)

        AggregateLifecycle.apply(
                UserCreateEvent(
                        command.id,
                        command.email,
                )
        )
    }

    @EventSourcingHandler
    fun on(event: UserCreateEvent) {
        logger.debug("event handler: {}", event)
        this.id = event.id
        this.email = event.email
    }
}