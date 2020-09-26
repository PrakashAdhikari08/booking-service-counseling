package com.bookingservice.bookingservice.controller;

import com.bookingservice.bookingservice.dto.BookingDto;
import com.bookingservice.bookingservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/booking/v1/")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("appointment/{customerName}")
    public ResponseEntity<String> makeAppointment(@RequestBody BookingDto bookingDto, @PathVariable String customerName){
                  bookingService.makeAppointment(bookingDto, customerName);
        return new ResponseEntity<>("Booked for "+customerName, HttpStatus.OK);
    }
}
