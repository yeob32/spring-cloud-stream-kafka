package com.example.stock

import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.context.annotation.Bean
import org.springframework.integration.support.MessageBuilder
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.Message
import org.springframework.stereotype.Component
import java.util.*
import java.util.function.Consumer

const val BINDING_NAME_OF_STOCK = "stockProcess-out-0"

@Component
class StockConsumer(private val streamBridge: StreamBridge) {
    @Bean
    fun stockProcess(): Consumer<Message<OrderMessage>> {
        return Consumer<Message<OrderMessage>> { message ->
            streamBridge.send(
                BINDING_NAME_OF_STOCK, MessageBuilder
                    .withPayload(OrderMessage(message.payload.orderNo))
                    .setHeader(KafkaHeaders.KEY, UUID.randomUUID().toString())
                    .build()
            )
        }
    }
}