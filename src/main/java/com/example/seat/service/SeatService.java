package com.example.seat.service;

import com.example.seat.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Time;
import java.util.List;

public interface SeatService {
    List<Seat> getSeatsByTimeRange(Time startTime, Time endTime);

    Seat bookSeat(String seatCode, Time startTime, Time endTime);
}