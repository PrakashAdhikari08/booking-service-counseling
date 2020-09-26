package com.bookingservice.bookingservice.service;

import com.bookingservice.bookingservice.dto.BookingDto;

public interface BookingService {
    Integer makeAppointment(BookingDto bookingDto, String customerName);
}
