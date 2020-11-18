package com.nnobs.service

import org.axonframework.eventsourcing.eventstore.EventStore
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class UserQueryService(
        private val eventStore: EventStore
) {
    fun listEvents(id: String): List<Any> =
            eventStore.readEvents(id).asStream().map { s -> s.payload }.collect(Collectors.toList())
}