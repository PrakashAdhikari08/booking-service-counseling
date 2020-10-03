package com.counseling.userservice.rabbitmq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface RabbitMqInputChannel {

    public final String  CHANNEL = "user-service";

    @Input(CHANNEL)
    SubscribableChannel booking();
}
