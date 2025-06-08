-- 1. Drop database if exists
DROP DATABASE IF EXISTS seat;

-- 2. Create database
CREATE DATABASE seat;

-- 3. Use the database
USE seat;

-- 4. Drop table if exists
DROP TABLE IF EXISTS seats;

-- 5. Create table
CREATE TABLE seats (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    room_name VARCHAR(255),
    seat_code VARCHAR(255),
    start_time TIME,
    end_time TIME,
    created_at TIMESTAMP NULL
);

-- 6. Insert data
INSERT INTO seats (room_name, seat_code, start_time, end_time, created_at) VALUES
('room1', 'A1', '12:00:00', '14:00:00', '2025-06-05 16:50:49'),
('room1', 'B2', '12:00:00', '14:00:00', '2025-06-05 16:50:49'),
('room1', 'C3', '12:00:00', '14:00:00', '2025-06-05 16:50:49');