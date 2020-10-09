package com.bookingservice.bookingservice.rabbitmq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CompensateBooking {


    public final String  BOOKING_COMPENSATION = "booking-service-compensated";

    @Output(BOOKING_COMPENSATION)
    MessageChannel bookingFailed();
}
