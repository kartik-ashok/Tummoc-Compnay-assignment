CREATE database TUMMOC;
USE TUMMOC;
CREATE TABLE ROUTES(id int primary key,name varchar(10) not null,number varchar(8) not null);
insert into ROUTES VALUES(1 ,'200-D','SBV-BHJ');
insert into ROUTES VALUES(2 ,'300-a','ASD-WE');

CREATE TABLE route_points(id int primary key auto_increment,route_id int ,foreign key(route_id) references ROUTES(id),orders int not null,distance int not null);


insert into  route_points value(1,1,1,0);
insert into  route_points value(2,1,2,100);
insert into  route_points value(3,2,1,0);
insert into  route_points value(4,2,2,50);
insert into  route_points value(5,2,3,100);

select * from routes;
select * from route_points;


SELECT
    rp.route_id,
    r.name,
    SUM(rp.distance) AS total_distance
FROM
    route_points rp
JOIN
    routes r ON rp.route_id = r.id
GROUP BY
    rp.route_id, r.name
ORDER BY
    total_distance DESC;


