package com.nnobs.config

import com.nnobs.domain.aggregate.UserAggregate
import org.axonframework.eventsourcing.EventSourcingRepository
import org.axonframework.eventsourcing.eventstore.EventStore
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class AxonConfig {

    @Bean
    fun userAggregateEventSourcingRepository(eventStore: EventStore): EventSourcingRepository<UserAggregate> {
        return EventSourcingRepository.builder(UserAggregate::class.java)
                .eventStore(eventStore)
                .build()
    }
}