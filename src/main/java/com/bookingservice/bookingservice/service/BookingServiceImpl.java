package com.bookingservice.bookingservice.service;

import com.bookingservice.bookingservice.domain.Booking;
import com.bookingservice.bookingservice.dto.BookingDto;
import com.bookingservice.bookingservice.exception.BookingNotFoundException;
import com.bookingservice.bookingservice.mapper.BookingMapper;
import com.bookingservice.bookingservice.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingMapper bookingMapper;

    @Override
    @Transactional
    public Integer makeAppointment(BookingDto bookingDto, Integer customerId) {
        System.out.println(customerId);
            bookingDto.setCustomerId(customerId);
//            bookingDto.setBookingTime(LocalTime.of(11,11));
//            bookingDto.setBookingDate(LocalDate.of(2010,11,10));
        Booking booking = bookingMapper.toEntity(bookingDto);
            bookingRepository.save(booking);
            return booking.getId();

    }

    @Override
    public List<BookingDto> getBookingCustomer(Integer customerId) {
        List<Booking> bookings = bookingRepository.findAllByCustomerId(customerId);
        if(bookings.isEmpty()){
            throw new BookingNotFoundException("No booking found for "+customerId);
        }
        List<BookingDto> bookingDtos = bookingMapper.toEntity(bookings);
        return bookingDtos;
    }

    @Override
    public Integer cancelBookingCustomer(Integer bookingId) {
       Optional<Booking> booking = bookingRepository.findById(bookingId);
       booking.orElseThrow(
               ()-> new BookingNotFoundException("No Booking Exist")
       );

       bookingRepository.delete(booking.get());
       return booking.get().getId();

    }
}
