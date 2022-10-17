CREATE TABLE theatre (
  id INT AUTO_INCREMENT NOT NULL,
   name VARCHAR(255) NULL,
   city_name VARCHAR(255) NULL,
   status TINYINT(1) DEFAULT true NULL,
   modified_date datetime NULL,
   created_date datetime NULL,
   CONSTRAINT pk_theatre PRIMARY KEY (id)
);

CREATE TABLE screen (
  id INT AUTO_INCREMENT NOT NULL,
   no_of_seats INT NOT NULL,
   no_of_rows INT NOT NULL,
   no_of_columns INT NOT NULL,
   theatre_id INT NULL,
   status TINYINT(1) DEFAULT true NULL,
   created_date datetime NULL,
   modified_date datetime NULL,
   CONSTRAINT pk_screen PRIMARY KEY (id)
);

ALTER TABLE screen ADD CONSTRAINT FK_SCREEN_ON_THEATRE FOREIGN KEY (theatre_id) REFERENCES theatre (id);

CREATE TABLE roles (
  id INT AUTO_INCREMENT NOT NULL,
   role_type VARCHAR(255) NULL,
   CONSTRAINT pk_roles PRIMARY KEY (id)
);

CREATE TABLE users (
  id INT AUTO_INCREMENT NOT NULL,
   name VARCHAR(255) NULL,
   email_id VARCHAR(255) NULL,
   contact_number BIGINT NOT NULL,
   password VARCHAR(255) NULL,
   created_date date NULL,
   modified_date date NULL,
   status BIT(1) NOT NULL,
   role_id INT NULL,
   CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE users ADD CONSTRAINT FK_USERS_ON_ROLE FOREIGN KEY (role_id) REFERENCES roles (id);

CREATE TABLE seat (
  id INT AUTO_INCREMENT NOT NULL,
   seat_no INT NOT NULL,
   seat_type VARCHAR(255) NULL,
   screen_id INT NULL,
   CONSTRAINT pk_seat PRIMARY KEY (id)
);

ALTER TABLE seat ADD CONSTRAINT FK_SEAT_ON_SCREEN FOREIGN KEY (screen_id) REFERENCES screen (id);

CREATE TABLE movie (
  id INT AUTO_INCREMENT NOT NULL,
   movie_name VARCHAR(255) NULL,
   release_date datetime NULL,
   duration time NULL,
   status BIT(1) NULL,
   created_date date NULL,
   modified_date date NULL,
   CONSTRAINT pk_movie PRIMARY KEY (id)
);

CREATE TABLE screening (
  id INT AUTO_INCREMENT NOT NULL,
   movie_id INT NULL,
   date date NULL,
   start_time time NULL,
   screen_id INT NULL,
   CONSTRAINT pk_screening PRIMARY KEY (id)
);

ALTER TABLE screening ADD CONSTRAINT FK_SCREENING_ON_MOVIE FOREIGN KEY (movie_id) REFERENCES movie (id);

ALTER TABLE screening ADD CONSTRAINT FK_SCREENING_ON_SCREEN FOREIGN KEY (screen_id) REFERENCES screen (id);

CREATE TABLE booking (
  id INT AUTO_INCREMENT NOT NULL,
   booking_date date NULL,
   user_id INT NULL,
   screening_id INT NULL,
   created_date date NULL,
   modified_date date NULL,
   status BIT(1) NOT NULL,
   CONSTRAINT pk_booking PRIMARY KEY (id)
);

ALTER TABLE booking ADD CONSTRAINT FK_BOOKING_ON_SCREENING FOREIGN KEY (screening_id) REFERENCES screening (id);

ALTER TABLE booking ADD CONSTRAINT FK_BOOKING_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

CREATE TABLE booked_seats (
  id INT AUTO_INCREMENT NOT NULL,
   seat_id INT NULL,
   booking_id INT NULL,
   screening_id INT NULL,
   CONSTRAINT pk_bookedseats PRIMARY KEY (id)
);

ALTER TABLE booked_seats ADD CONSTRAINT FK_BOOKEDSEATS_ON_BOOKING FOREIGN KEY (booking_id) REFERENCES booking (id);

ALTER TABLE booked_seats ADD CONSTRAINT FK_BOOKEDSEATS_ON_SCREENING FOREIGN KEY (screening_id) REFERENCES screening (id);

ALTER TABLE booked_seats ADD CONSTRAINT FK_BOOKEDSEATS_ON_SEAT FOREIGN KEY (seat_id) REFERENCES seat (id);