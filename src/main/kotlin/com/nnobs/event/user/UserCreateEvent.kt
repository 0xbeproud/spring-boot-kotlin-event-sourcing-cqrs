package com.nnobs.event.user

import com.nnobs.event.BaseEvent

class UserCreateEvent (
       override val id: String,
       val email: String,
       val point: Int
): BaseEvent<String>(id)