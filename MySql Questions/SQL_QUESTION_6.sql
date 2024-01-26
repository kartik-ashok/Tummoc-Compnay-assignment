-- Create the station table
CREATE TABLE station (
    id INT PRIMARY KEY,
    station_name VARCHAR(20) NOT NULL
);

-- Insert sample data into station table
INSERT INTO station (id, station_name) VALUES
(1, 'STA 1'),
(2, 'STB 2');


select * from station;

-- Create the times table with foreign key
CREATE TABLE times (
    id INT PRIMARY KEY,
    station_id INT,
    slot INT,
    time TIME,
    FOREIGN KEY (station_id) REFERENCES station(id)
);

-- Insert sample data into times table
INSERT INTO times (id, station_id, slot, time) VALUES
(1, 1, 1, '6:30'),
(2, 1, 2, '6:45'),
(3, 1, 1, '7:40'),
(4, 1, 2, '7:25'),
(5, 2, 1, '6:40'),
(6, 2, 2, '6:50'),
(7, 2, 1, '7:50'),
(8, 2, 2, '8:15');

select * from times;


SELECT
    t.station_id,
    s.station_name,
    t.slot,
    t.time
FROM
    times t
JOIN
    station s ON t.station_id = s.id
WHERE
    t.slot = 1
    AND TIME_FORMAT(t.time, '%H:%i') < '07:45'
ORDER BY
    t.time;

