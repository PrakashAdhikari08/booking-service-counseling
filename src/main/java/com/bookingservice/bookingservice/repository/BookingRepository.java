package com.bookingservice.bookingservice.repository;

import com.bookingservice.bookingservice.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking , Integer> {
}
