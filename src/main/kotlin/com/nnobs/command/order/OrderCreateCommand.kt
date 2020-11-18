package com.nnobs.command.order

import com.nnobs.command.BaseCommand
import org.axonframework.modelling.command.TargetAggregateIdentifier

class OrderCreateCommand(
        @TargetAggregateIdentifier override val id: String,
        val name: String,
        val price: Int
) : BaseCommand<String>(id)