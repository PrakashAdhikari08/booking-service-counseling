package com.bookingservice.bookingservice.repository;

import com.bookingservice.bookingservice.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking , Integer> {
    List<Booking> findAllByCustomerId(Integer customerId);
}
