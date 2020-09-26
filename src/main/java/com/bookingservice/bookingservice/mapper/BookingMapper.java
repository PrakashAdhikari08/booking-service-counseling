package com.bookingservice.bookingservice.mapper;

import com.bookingservice.bookingservice.domain.Booking;
import com.bookingservice.bookingservice.dto.BookingDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingMapper {

        Booking toEntity(BookingDto bookingDto);

        BookingDto toDto(Booking booking);

        List<Booking> toBookingList(List<BookingDto> bookingDtoList);

        List<BookingDto> toEntity(List<Booking> bookings);
}
