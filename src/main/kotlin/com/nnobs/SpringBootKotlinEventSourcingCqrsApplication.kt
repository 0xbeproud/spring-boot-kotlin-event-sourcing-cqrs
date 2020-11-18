package com.nnobs

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootKotlinEventSourcingCqrsApplication

fun main(args: Array<String>) {
    runApplication<SpringBootKotlinEventSourcingCqrsApplication>(*args)
}
