CREATE TABLE IF NOT EXISTS reservation (
    id int NOT NULL AUTO_INCREMENT,
    email varchar(100) NOT NULL,
    room_type varchar(100) NOT NULL,
    reservation_date datetime NOT NULL,
    check_in_date datetime NOT NULL,
    check_out_date datetime NOT NULL,
    number_of_rooms int NOT NULL,
    amount decimal(10,2) NOT NULL,
    PRIMARY KEY (id)
);