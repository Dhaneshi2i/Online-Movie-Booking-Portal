CREATE TABLE booked_seats (
  id INT NOT NULL,
   seat_id INT NULL,
   booking_id INT NULL,
   screening_id INT NULL,
   CONSTRAINT pk_bookedseats PRIMARY KEY (id)
);

ALTER TABLE booked_seats ADD CONSTRAINT FK_BOOKEDSEATS_ON_BOOKING FOREIGN KEY (booking_id) REFERENCES booking (id);

ALTER TABLE booked_seats ADD CONSTRAINT FK_BOOKEDSEATS_ON_SCREENING FOREIGN KEY (screening_id) REFERENCES screening (id);

ALTER TABLE booked_seats ADD CONSTRAINT FK_BOOKEDSEATS_ON_SEAT FOREIGN KEY (seat_id) REFERENCES seat (id);