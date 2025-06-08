package com.example.seat.controller;

import com.example.seat.entity.Seat;
import com.example.seat.service.SeatService;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://ktpm-lab01-frontend.onrender.com"
})
@RestController
@RequestMapping("/api")
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/seats")
    public List<Seat> getSeatsByTime(
            @RequestParam String startTime,   // "12:00:00"
            @RequestParam String endTime      // "14:00:00"
    ) {
        Time start = Time.valueOf(startTime);
        Time end = Time.valueOf(endTime);
        return seatService.getSeatsByTimeRange(start, end);
    }

    @PostMapping("/book")
    public Seat bookSeat(@RequestBody Map<String, String> request) {
        String seatCode = request.get("seatCode");
        String startTimeStr = request.get("startTime");
        String endTimeStr = request.get("endTime");

        if (seatCode == null || startTimeStr == null || endTimeStr == null) {
            throw new IllegalArgumentException("Thiếu thông tin đầu vào.");
        }

        Time startTime = Time.valueOf(startTimeStr);
        Time endTime = Time.valueOf(endTimeStr);

        return seatService.bookSeat(seatCode, startTime, endTime);
    }
}