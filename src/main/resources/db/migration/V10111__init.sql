CREATE TABLE roles (
  role_id INT AUTO_INCREMENT NOT NULL,
   role_type VARCHAR(40) NULL,
   CONSTRAINT pk_roles PRIMARY KEY (role_id)
);


CREATE TABLE users (
  user_id INT AUTO_INCREMENT NOT NULL,
   user_name VARCHAR(40) NULL,
   email_id VARCHAR(40) NULL,
   contact_number BIGINT NOT NULL,
   password VARCHAR(255) NULL,
   created_on datetime NULL,
   updated_on datetime NULL,
   status BIT(1) NOT NULL,
   role_id INT NULL,
   CONSTRAINT pk_users PRIMARY KEY (user_id)
);

ALTER TABLE users ADD CONSTRAINT FK_USERS_ON_ROLE FOREIGN KEY (role_id) REFERENCES roles (role_id);
CREATE TABLE languages (
  language_id INT AUTO_INCREMENT NOT NULL,
   name VARCHAR(40) NULL,
   CONSTRAINT pk_languages PRIMARY KEY (language_id)
);
CREATE TABLE cast (
  cast_id INT AUTO_INCREMENT NOT NULL,
   cast_name VARCHAR(40) NULL,
   cast_role VARCHAR(40) NULL,
   CONSTRAINT pk_cast PRIMARY KEY (cast_id)
);
CREATE TABLE genre (
  genre_id INT AUTO_INCREMENT NOT NULL,
   genre_name VARCHAR(40) NULL,
   CONSTRAINT pk_genre PRIMARY KEY (genre_id)
);
CREATE TABLE movies (
  movie_id INT AUTO_INCREMENT NOT NULL,
   movie_name VARCHAR(40) NULL,
   duration time NULL,
   release_date date NULL,
   status BIT(1) NOT NULL,
   created_on datetime NULL,
   updated_on datetime NULL,
   CONSTRAINT pk_movies PRIMARY KEY (movie_id)
);
CREATE TABLE movie_cast (
  cast_id INT NOT NULL,
   movie_id INT NOT NULL
);

ALTER TABLE movie_cast ADD CONSTRAINT fk_movcas_on_cast FOREIGN KEY (cast_id) REFERENCES cast (cast_id);

ALTER TABLE movie_cast ADD CONSTRAINT fk_movcas_on_movie FOREIGN KEY (movie_id) REFERENCES movies (movie_id);
CREATE TABLE movie_genre (
  genre_id INT NOT NULL,
   movie_id INT NOT NULL
);

ALTER TABLE movie_genre ADD CONSTRAINT fk_movgen_on_genre FOREIGN KEY (genre_id) REFERENCES genre (genre_id);

ALTER TABLE movie_genre ADD CONSTRAINT fk_movgen_on_movie FOREIGN KEY (movie_id) REFERENCES movies (movie_id);
CREATE TABLE movie_language (
  language_id INT NOT NULL,
   movie_id INT NOT NULL
);

ALTER TABLE movie_language ADD CONSTRAINT fk_movlan_on_language FOREIGN KEY (language_id) REFERENCES languages (language_id);

ALTER TABLE movie_language ADD CONSTRAINT fk_movlan_on_movie FOREIGN KEY (movie_id) REFERENCES movies (movie_id);

CREATE TABLE theatres (
  theatre_id INT AUTO_INCREMENT NOT NULL,
   theatre_name VARCHAR(40) NULL,
   theatre_city VARCHAR(40) NULL,
   status BIT(1) NOT NULL,
   created_on datetime NULL,
   update_on datetime NULL,
   CONSTRAINT pk_theatres PRIMARY KEY (theatre_id)
);

CREATE TABLE screens (
  screen_id INT AUTO_INCREMENT NOT NULL,
   screen_name VARCHAR(40) NULL,
   theatre_id INT NULL,
   status BIT(1) NOT NULL,
   created_on datetime NULL,
   updated_on datetime NULL,
   CONSTRAINT pk_screens PRIMARY KEY (screen_id)
);

ALTER TABLE screens ADD CONSTRAINT FK_SCREENS_ON_THEATRE FOREIGN KEY (theatre_id) REFERENCES theatres (theatre_id);


CREATE TABLE seat_type (
  seat_type_id INT AUTO_INCREMENT NOT NULL,
   seat_type VARCHAR(40) NULL,
   no_of_columns INT NOT NULL,
   no_of_rows INT NOT NULL,
   price FLOAT NOT NULL,
   CONSTRAINT pk_seat_type PRIMARY KEY (seat_type_id)
);

CREATE TABLE time_slots (
  time_slot_id INT AUTO_INCREMENT NOT NULL,
   show_start_time time NULL,
   CONSTRAINT pk_time_slots PRIMARY KEY (time_slot_id)
);

CREATE TABLE shows (
  show_id INT AUTO_INCREMENT NOT NULL,
   show_date date NULL,
   movie_id INT NULL,
   screen_id INT NULL,
   theatre_id INT NULL,
   status BIT(1) NOT NULL,
   show_start_time time NULL,
   CONSTRAINT pk_shows PRIMARY KEY (show_id)
);

ALTER TABLE shows ADD CONSTRAINT FK_SHOWS_ON_MOVIE FOREIGN KEY (movie_id) REFERENCES movies (movie_id);

ALTER TABLE shows ADD CONSTRAINT FK_SHOWS_ON_SCREEN FOREIGN KEY (screen_id) REFERENCES screens (screen_id);

ALTER TABLE shows ADD CONSTRAINT FK_SHOWS_ON_THEATRE FOREIGN KEY (theatre_id) REFERENCES theatres (theatre_id);

CREATE TABLE seats (
  seat_id INT AUTO_INCREMENT NOT NULL,
   seat_number VARCHAR(255) NULL,
   seat_type_id INT NOT NULL,
   show_date date NULL,
   show_start_time_time_slot_id INT NULL,
   seat_price FLOAT NOT NULL,
   screen_id_id INT NULL,
   show_show_id INT NULL,
   seat_status VARCHAR(255) NULL,
   created_on datetime NULL,
   updated_on datetime NULL,
   CONSTRAINT pk_seats PRIMARY KEY (seat_id)
);

ALTER TABLE seats ADD CONSTRAINT FK_SEATS_ON_SCREEN_ID FOREIGN KEY (screen_id_id) REFERENCES screens (screen_id);

ALTER TABLE seats ADD CONSTRAINT FK_SEATS_ON_SEATTYPEID FOREIGN KEY (seat_type_id) REFERENCES seat_type (seat_type_id);

ALTER TABLE seats ADD CONSTRAINT FK_SEATS_ON_SHOW_SHOW FOREIGN KEY (show_show_id) REFERENCES shows (show_id);

ALTER TABLE seats ADD CONSTRAINT FK_SEATS_ON_SHOW_START_TIME_TIME_SLOT FOREIGN KEY (show_start_time_time_slot_id) REFERENCES time_slots (time_slot_id);

CREATE TABLE screens_time_slots (
  id INT AUTO_INCREMENT NOT NULL,
  screen_screen_id INT NOT NULL,
   time_slots_time_slot_id INT NOT NULL,
   CONSTRAINT pk_booking_seats PRIMARY KEY (id)
);


ALTER TABLE screens_time_slots ADD CONSTRAINT fk_scrtimslo_on_screen FOREIGN KEY (screen_screen_id) REFERENCES screens (screen_id);

ALTER TABLE screens_time_slots ADD CONSTRAINT fk_scrtimslo_on_time_slot FOREIGN KEY (time_slots_time_slot_id) REFERENCES time_slots (time_slot_id);

CREATE TABLE screens_seat_types (
  id INT AUTO_INCREMENT NOT NULL,
  screen_screen_id INT NOT NULL,
   seat_types_seat_type_id INT NOT NULL,
   CONSTRAINT pk_booking_seats PRIMARY KEY (id)
);

ALTER TABLE screens_seat_types ADD CONSTRAINT fk_scrseatyp_on_screen FOREIGN KEY (screen_screen_id) REFERENCES screens (screen_id);

ALTER TABLE screens_seat_types ADD CONSTRAINT fk_scrseatyp_on_seat_type FOREIGN KEY (seat_types_seat_type_id) REFERENCES seat_type (seat_type_id);

CREATE TABLE booking (
  booking_id INT AUTO_INCREMENT NOT NULL,
   transaction_mode VARCHAR(40) NULL,
   user_user_id INT NULL,
   show_id INT NULL,
   booking_date date NULL,
   booking_status VARCHAR(40) NULL,
   total_cost FLOAT NOT NULL,
   CONSTRAINT pk_booking PRIMARY KEY (booking_id)
);

ALTER TABLE booking ADD CONSTRAINT FK_BOOKING_ON_SHOW FOREIGN KEY (show_id) REFERENCES shows (show_id);

ALTER TABLE booking ADD CONSTRAINT FK_BOOKING_ON_USER_USERID FOREIGN KEY (user_user_id) REFERENCES users (user_id);

CREATE TABLE booking_seats (
  id INT AUTO_INCREMENT NOT NULL,
  booking_booking_id INT NOT NULL,
   seats_seat_id INT NOT NULL,
   CONSTRAINT pk_booking_seats PRIMARY KEY (id)
);

ALTER TABLE booking_seats ADD CONSTRAINT fk_boosea_on_booking FOREIGN KEY (booking_booking_id) REFERENCES booking (booking_id);

ALTER TABLE booking_seats ADD CONSTRAINT fk_boosea_on_seat FOREIGN KEY (seats_seat_id) REFERENCES seats (seat_id);


