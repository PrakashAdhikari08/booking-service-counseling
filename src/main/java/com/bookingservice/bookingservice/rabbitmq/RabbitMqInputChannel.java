package com.bookingservice.bookingservice.rabbitmq;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;


public interface RabbitMqInputChannel {

    public final String  CHANNEL = "booking-service";

    public final String  BOOKING_CONFORMATION = "booking-service-booked";


    @Input(CHANNEL)
    SubscribableChannel booking();

    @Output(BOOKING_CONFORMATION)
    MessageChannel bookingConfrmed();


}
