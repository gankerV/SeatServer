package com.example.seat.service.iml;

import com.example.seat.entity.Seat;
import com.example.seat.repository.SeatRepository;
import com.example.seat.service.SeatService;
import org.springframework.stereotype.Service;
import java.sql.Time;
import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;

    public SeatServiceImpl(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public List<Seat> getSeatsByTimeRange(Time startTime, Time endTime) {
        return seatRepository.findByStartTimeAndEndTime(startTime, endTime);
    }

    @Override
    public Seat bookSeat(String seatCode, Time startTime, Time endTime) {
        // Kiểm tra nếu ghế đã được đặt
        List<Seat> existingSeats = seatRepository.findByStartTimeAndEndTime(startTime, endTime);
        boolean alreadyBooked = existingSeats.stream()
                .anyMatch(seat -> seat.getSeatCode().equalsIgnoreCase(seatCode));

        if (alreadyBooked) {
            throw new IllegalStateException("Seat " + seatCode + " đã được đặt.");
        }

        // Tạo mới seat
        Seat seat = new Seat("room1", seatCode, startTime, endTime);
        return seatRepository.save(seat);
    }
}