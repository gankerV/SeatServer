package com.example.seat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.seat.entity.Seat;
import java.sql.Time;
import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByStartTimeAndEndTime(Time startTime, Time endTime);
}