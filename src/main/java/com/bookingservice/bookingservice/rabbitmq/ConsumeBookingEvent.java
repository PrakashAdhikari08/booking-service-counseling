package com.bookingservice.bookingservice.rabbitmq;


import com.bookingservice.bookingservice.dto.BookingDto;
import com.bookingservice.bookingservice.service.BookingService;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(RabbitMqInputChannel.class)
public class ConsumeBookingEvent {

    @Autowired
    private BookingService bookingService;

    @Autowired
    RabbitMqInputChannel rabbitMqInputChannel;

    @StreamListener(target = RabbitMqInputChannel.CHANNEL)
    public void processBooking(BookingDto bookingDto) {
        bookingService.makeAppointment(bookingDto,1);

        Message<Integer> message = MessageBuilder.withPayload(bookingDto.getCustomerId())
                .build();
        rabbitMqInputChannel.bookingConfrmed().send(message);

        System.out.println("message consumed  for " + bookingDto.getCustomerId());
    }

}
