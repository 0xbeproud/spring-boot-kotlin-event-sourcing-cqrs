package com.nnobs.command.user

import com.nnobs.command.BaseCommand
import org.axonframework.modelling.command.TargetAggregateIdentifier

class UserCreateCommand(
        @TargetAggregateIdentifier override val id: String,
        val email: String
) : BaseCommand<String>(id)