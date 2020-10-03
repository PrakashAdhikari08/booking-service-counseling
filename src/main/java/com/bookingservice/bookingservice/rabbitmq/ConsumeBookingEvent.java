package com.bookingservice.bookingservice.rabbitmq;


import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigRabbitMq {

    @Bean
    Queue queue(){
        return new Queue("booking_queue", true);
    }

}
