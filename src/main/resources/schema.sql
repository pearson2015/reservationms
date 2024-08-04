CREATE TABLE IF NOT EXISTS reservation (
    id int NOT NULL AUTO_INCREMENT,
    email varchar(100) NOT NULL,
    room_number varchar(50) NOT NULL,
    room_type varchar(100) NOT NULL,
    reservation_date datetime NOT NULL,
    reservation_status varchar(50) NOT NULL,
    price decimal(10,2) NOT NULL,
    payment_transaction_id varchar(100) NOT NULL,
    PRIMARY KEY (id)
);