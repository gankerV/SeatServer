package com.example.seat.entity;

import jakarta.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_name")
    private String roomName;

    @Column(name = "seat_code")
    private String seatCode;

    @Column(name = "start_time")
    private Time startTime;

    @Column(name = "end_time")
    private Time endTime;

    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    // Constructors
    public Seat() {}

    public Seat(String roomName, String seatCode, Time startTime, Time endTime) {
        this.roomName = roomName;
        this.seatCode = seatCode;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public String getRoomName() { return roomName; }
    public void setRoomName(String roomName) { this.roomName = roomName; }

    public String getSeatCode() { return seatCode; }
    public void setSeatCode(String seatCode) { this.seatCode = seatCode; }

    public Time getStartTime() { return startTime; }
    public void setStartTime(Time startTime) { this.startTime = startTime; }

    public Time getEndTime() { return endTime; }
    public void setEndTime(Time endTime) { this.endTime = endTime; }

    public java.sql.Timestamp getCreatedAt() { return createdAt; }
}
