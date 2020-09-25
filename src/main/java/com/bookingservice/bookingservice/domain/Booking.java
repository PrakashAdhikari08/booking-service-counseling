package com.bookingservice.bookingservice.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
public class Booking {

    @Id
    private Integer id;

    private LocalDate bookingDate;

    private LocalTime bookingTime;

    private LocalDateTime bookedOn;
}
