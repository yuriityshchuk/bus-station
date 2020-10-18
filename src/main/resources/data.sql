INSERT INTO role(id, name)
VALUES (1, 'ADMIN'),
       (2, 'USER');

INSERT INTO user(id, username, first_name, last_name, registration_date, password, email, telephone, gender, locked)
VALUES (1, 'test', 'test', 'test', sysdate(), '$2a$10$UL0oHA21nLWCrUknMKamR.sstth5KgFA6qukhoNbRH4pKXPlLYDXO',
        'test@gmail.com', '0993400231', 'MALE', 0),
       (2, 'test1', 'test', 'test', sysdate(), '$2a$10$UL0oHA21nLWCrUknMKamR.sstth5KgFA6qukhoNbRH4pKXPlLYDXO',
        'test5@gmail.com', '0953400234', 'FEMALE', 0);

INSERT INTO user_roles(user_id, role_id)
VALUES (1, 1),
       (2, 2);


INSERT INTO driver(id, first_name, last_name, gender, driver_license)
VALUES (1, 'Danil', 'Grymovsky', 'MALE', 'VKS21DAAS'),
       (2, 'Artur', 'Mikhayliv', 'MALE', 'VA221GF3');

INSERT INTO bus(id, number, name, max_number_of_passengers, create_date, VIN, bus_class, currently_used)
VALUES (1, 'VK1228AC', 'Mercedes', 50, sysdate, 'VSADSA3421321', 1, 1),
       (2, 'AA2141AC', 'TATA', 45, sysdate, 'VADASD31421', 2, 1);

INSERT INTO driver_bus(driver_id, bus_id)
VALUES (1, 2),
       (2, 1);

INSERT INTO city(id, name, region)
VALUES (1, 'Rivne', 'Rivne'),
       (2, 'Lviv', 'Lviv'),
       (3, 'Kyiv', 'Kyiv');

INSERT INTO stop(id, city_id, duration)
VALUES (1, 2, 25),
       (2, 3, 29);

INSERT INTO route(id, arrival_place_id, arrival_date, departure_place_id, departure_date, number_of_passengers, bus_id)
VALUES (1, 2, sysdate, 1, sysdate, 20, 1),
       (2, 1, sysdate, 3, sysdate, 19, 2);

INSERT INTO ticket(id, buy_time, user_id, status, route_id, client_email)
VALUES (1, sysdate, 1, 'ACTIVE', 1, 'test@gmail.com'),
       (2, sysdate, 2, 'INACTIVE', 2, 'test1@gmail.com'),
       (3, sysdate, 1, 'ACTIVE', 1, 'test2@gmail.com');
