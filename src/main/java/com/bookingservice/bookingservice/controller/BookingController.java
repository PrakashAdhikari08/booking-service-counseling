package com.bookingservice.bookingservice.controller;

import com.bookingservice.bookingservice.dto.BookingDto;
import com.bookingservice.bookingservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/booking/v1/")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("appointment/{customerId}")
    public ResponseEntity<String> makeAppointment(@RequestBody BookingDto bookingDto, @PathVariable Integer customerId){
                  bookingService.makeAppointment(bookingDto, customerId);
        return new ResponseEntity<>("Booked for "+customerId, HttpStatus.OK);
    }

    @GetMapping("get-all-booking/{customerId}")
    public List<BookingDto> getBookingCustomer(@PathVariable Integer customerId){
        return bookingService.getBookingCustomer(customerId);
    }

    @DeleteMapping("delete/{bookingId}")
    public Integer cancelBookingCustomer(@PathVariable Integer bookingId){
        return bookingService.cancelBookingCustomer(bookingId);
    }
}
