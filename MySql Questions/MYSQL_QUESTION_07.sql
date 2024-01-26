drop table routes;
drop table route_points;
-- Create the routes table
CREATE TABLE routes (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    number VARCHAR(255) NOT NULL
);

-- Insert sample data into routes table
INSERT INTO routes (id, name, number) VALUES
(1, '200-D', 'SBV-BHJ'),
(2, '300-D', 'ASD-WER');

-- Create the route_points table
CREATE TABLE route_points (
    id INT PRIMARY KEY,
    route_id INT NOT NULL,
    station_id INT NOT NULL,
    `order` INT NOT NULL,
    stop_id INT NOT NULL,
    FOREIGN KEY (route_id) REFERENCES routes(id)
);

-- Insert sample data into route_points table
INSERT INTO route_points (id, route_id, station_id, `order`, stop_id) VALUES
(1, 1, 1, 1, 1),
(2, 1, 1, 2, 2),
(3, 2, 2, 1, 1),
(4, 2, 2, 2, 2),
(5, 2, 2, 3, 3);



SELECT
    rp1.route_id,
    rp1.stop_id AS source_stop_id,
    rp2.stop_id AS dest_stop_id
FROM
    route_points rp1
JOIN
    route_points rp2 ON rp1.route_id = rp2.route_id
WHERE
    rp1.order < rp2.order
ORDER BY
    rp1.route_id, rp1.order;
    
    
-- OPTIONAL QUESTION


SELECT
    rp.route_id,
    s1.station_name AS source_station,
    s2.station_name AS dest_station
FROM
    route_points rp
JOIN
    station s1 ON rp.stop_id = s1.id
JOIN
    route_points rp2 ON rp.route_id = rp2.route_id AND rp.order + 1 = rp2.order
JOIN
    station s2 ON rp2.stop_id = s2.id
WHERE
    rp.order < (SELECT MAX(`order`) FROM route_points WHERE route_id = rp.route_id)
ORDER BY
    rp.route_id, rp.order;


