package com.bookingservice.bookingservice.service;

import com.bookingservice.bookingservice.domain.Booking;
import com.bookingservice.bookingservice.dto.BookingDto;
import com.bookingservice.bookingservice.mapper.BookingMapper;
import com.bookingservice.bookingservice.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingMapper bookingMapper;

    @Override
    @Transactional
    public Integer makeAppointment(BookingDto bookingDto, String customerName) {
        System.out.println(customerName);
            bookingDto.setCustomerName(customerName);
//            bookingDto.setBookingTime(LocalTime.of(11,11));
//            bookingDto.setBookingDate(LocalDate.of(2010,11,10));
        Booking booking = bookingMapper.toEntity(bookingDto);
            bookingRepository.save(booking);
            return booking.getId();

    }
}
