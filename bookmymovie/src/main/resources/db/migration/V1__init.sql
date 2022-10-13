
CREATE TABLE booked_seats (
  id INT NOT NULL,
   seat_id INT NULL,
   booking_id INT NULL,
   screening_id INT NULL,
   CONSTRAINT pk_bookedseats PRIMARY KEY (id)
);

ALTER TABLE booked_seats ADD CONSTRAINT FK_BOOKEDSEATS_ON_BOOKING FOREIGN KEY (booking_id) REFERENCES booking (id);


CREATE TABLE movie (
  id INT NOT NULL,
   movie_name VARCHAR(255) NULL,
   release_date date NULL,
   duration time NULL,
   CONSTRAINT pk_movie PRIMARY KEY (id)
);

