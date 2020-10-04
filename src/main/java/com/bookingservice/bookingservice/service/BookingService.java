package com.bookingservice.bookingservice.service;

import com.bookingservice.bookingservice.dto.BookingDto;

import java.util.List;

public interface BookingService {
    Integer makeAppointment(BookingDto bookingDto, Integer customerId);

    List<BookingDto> getBookingCustomer(Integer customerId);

    Integer cancelBookingCustomer(Integer bookingId);
}
