package com.example.order

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}

@Component
class ApplicationRunner(private val orderProducer: OrderProducer) : ApplicationRunner {
    var index = 0L
    override fun run(args: ApplicationArguments?) {
        while (true) {
            Thread.sleep(1000)
            orderProducer.order(OrderMessage(index++))
        }
    }
}