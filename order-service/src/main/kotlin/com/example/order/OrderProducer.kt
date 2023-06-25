package com.example.order

import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.integration.support.MessageBuilder
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.stereotype.Component
import java.util.*

const val BINDING_NAME_OF_ORDER = "order-create"

@Component
class OrderProducer(private val streamBridge: StreamBridge) {
    fun order(orderMessage: OrderMessage) {
        streamBridge.send(
            BINDING_NAME_OF_ORDER, MessageBuilder
                .withPayload(orderMessage)
                .setHeader(KafkaHeaders.KEY, UUID.randomUUID().toString())
                .build()
        )
    }
}