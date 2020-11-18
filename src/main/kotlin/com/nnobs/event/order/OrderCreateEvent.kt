package com.nnobs.event.order

import com.nnobs.event.BaseEvent

class OrderCreateEvent(
        override val id: String,
        val name: String,
        val price: Int
) : BaseEvent<String>(id)