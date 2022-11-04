CREATE TABLE roles (
  role_id INT AUTO_INCREMENT NOT NULL,
   role_type VARCHAR(40) NULL,
   CONSTRAINT pk_roles PRIMARY KEY (role_id)
);

insert into roles (role_type) values ("Admin");
insert into roles (role_type) values ("Customer");

CREATE TABLE users (
  user_id INT AUTO_INCREMENT NOT NULL,
   user_name VARCHAR(40) NULL,
   email_id VARCHAR(40) NULL,
   contact_number BIGINT NOT NULL,
   password VARCHAR(255) NULL,
   created_on datetime NULL,
   updated_on datetime NULL,
   status INT NOT NULL,
   role_id INT NULL,
   CONSTRAINT pk_users PRIMARY KEY (user_id)
);

ALTER TABLE users ADD CONSTRAINT FK_USERS_ON_ROLE FOREIGN KEY (role_id) REFERENCES roles (role_id);

CREATE TABLE languages (
  language_id INT AUTO_INCREMENT NOT NULL,
   language_name VARCHAR(40) NULL,
   CONSTRAINT pk_languages PRIMARY KEY (language_id)
);

CREATE TABLE genres (
  genre_id INT AUTO_INCREMENT NOT NULL,
   genre_name VARCHAR(40) NULL,
   CONSTRAINT pk_genres PRIMARY KEY (genre_id)
);

CREATE TABLE casts (
  cast_id INT AUTO_INCREMENT NOT NULL,
   cast_name VARCHAR(40) NULL,
   cast_role VARCHAR(40) NULL,
   CONSTRAINT pk_casts PRIMARY KEY (cast_id)
);

CREATE TABLE movies (
  movie_id INT AUTO_INCREMENT NOT NULL,
   movie_name VARCHAR(40) NULL,
   duration time NULL,
   release_date date NULL,
   status INT NOT NULL,
   created_on datetime NULL,
   updated_on datetime NULL,
   CONSTRAINT pk_movies PRIMARY KEY (movie_id)
);

CREATE TABLE movie_language (
  language_id INT NOT NULL,
   movie_id INT NOT NULL
);

ALTER TABLE movie_language ADD CONSTRAINT fk_movlan_on_language FOREIGN KEY (language_id) REFERENCES languages (language_id);

ALTER TABLE movie_language ADD CONSTRAINT fk_movlan_on_movie FOREIGN KEY (movie_id) REFERENCES movies (movie_id);

CREATE TABLE movie_genre (
  genre_id INT NOT NULL,
   movie_id INT NOT NULL
);

ALTER TABLE movie_genre ADD CONSTRAINT fk_movgen_on_genre FOREIGN KEY (genre_id) REFERENCES genres (genre_id);

ALTER TABLE movie_genre ADD CONSTRAINT fk_movgen_on_movie FOREIGN KEY (movie_id) REFERENCES movies (movie_id);

CREATE TABLE movie_cast (
  cast_id INT NOT NULL,
   movie_id INT NOT NULL
);

ALTER TABLE movie_cast ADD CONSTRAINT fk_movcas_on_cast FOREIGN KEY (cast_id) REFERENCES casts (cast_id);

ALTER TABLE movie_cast ADD CONSTRAINT fk_movcas_on_movie FOREIGN KEY (movie_id) REFERENCES movies (movie_id);

CREATE TABLE theatres (
  theatre_id INT AUTO_INCREMENT NOT NULL,
   theatre_name VARCHAR(40) NULL,
   theatre_city VARCHAR(40) NULL,
   status INT NOT NULL,
   created_on datetime NULL,
   update_on datetime NULL,
   CONSTRAINT pk_theatres PRIMARY KEY (theatre_id)
);

CREATE TABLE screens (
  screen_id INT AUTO_INCREMENT NOT NULL,
   screen_name VARCHAR(40) NULL,
   theatre_theatre_id INT NULL,
   status INT NOT NULL,
   created_on datetime NULL,
   updated_on datetime NULL,
   CONSTRAINT pk_screens PRIMARY KEY (screen_id)
);

ALTER TABLE screens ADD CONSTRAINT FK_SCREENS_ON_THEATRE_THEATRE FOREIGN KEY (theatre_theatre_id) REFERENCES theatres (theatre_id);

CREATE TABLE seat_type (
  seat_type_id INT AUTO_INCREMENT NOT NULL,
   seat_type VARCHAR(40) NULL,
   no_of_columns INT NOT NULL,
   no_of_rows INT NOT NULL,
   price FLOAT NOT NULL,
   screen_seat_type_id INT NULL,
   CONSTRAINT pk_seat_type PRIMARY KEY (seat_type_id)
);

ALTER TABLE seat_type ADD CONSTRAINT FK_SEAT_TYPE_ON_SCREEN_SEAT_TYPE FOREIGN KEY (screen_seat_type_id) REFERENCES screens (screen_id);

CREATE TABLE shows (
  show_id INT AUTO_INCREMENT NOT NULL,
   show_date date NULL,
   show_start_time time NULL,
   movie_id INT NULL,
   show_screen_id INT NULL,
   status INT NOT NULL,
   CONSTRAINT pk_shows PRIMARY KEY (show_id)
);

ALTER TABLE shows ADD CONSTRAINT FK_SHOWS_ON_MOVIE FOREIGN KEY (movie_id) REFERENCES movies (movie_id);

ALTER TABLE shows ADD CONSTRAINT FK_SHOWS_ON_SHOW_SCREEN FOREIGN KEY (show_screen_id) REFERENCES screens (screen_id);

CREATE TABLE time_slots (
  time_slot_id INT AUTO_INCREMENT NOT NULL,
   show_start_time time NULL,
   CONSTRAINT pk_time_slots PRIMARY KEY (time_slot_id)
);

CREATE TABLE booking (
  booking_id INT AUTO_INCREMENT NOT NULL,
   transaction_mode VARCHAR(40) NULL,
   user_id INT NULL,
   show_id INT NULL,
   booking_date date NULL,
   booking_status VARCHAR(40) NULL,
   total_cost FLOAT NOT NULL,
   CONSTRAINT pk_booking PRIMARY KEY (booking_id)
);

ALTER TABLE booking ADD CONSTRAINT FK_BOOKING_ON_SHOW FOREIGN KEY (show_id) REFERENCES shows (show_id);

ALTER TABLE booking ADD CONSTRAINT FK_BOOKING_ON_USER FOREIGN KEY (user_id) REFERENCES users (user_id);

CREATE TABLE seats (
  seat_id INT AUTO_INCREMENT NOT NULL,
   seat_number VARCHAR(40) NULL,
   seat_type_id INT NOT NULL,
   show_date date NULL,
   seat_price FLOAT NOT NULL,
   show_show_id INT NULL,
   seat_status VARCHAR(40) NULL,
   created_on datetime NULL,
   updated_on datetime NULL,
   booking_seat_id INT NULL,
   CONSTRAINT pk_seats PRIMARY KEY (seat_id)
);

ALTER TABLE seats ADD CONSTRAINT FK_SEATS_ON_BOOKING_SEAT FOREIGN KEY (booking_seat_id) REFERENCES booking (booking_id);

ALTER TABLE seats ADD CONSTRAINT FK_SEATS_ON_SEATTYPEID FOREIGN KEY (seat_type_id) REFERENCES seat_type (seat_type_id);

ALTER TABLE seats ADD CONSTRAINT FK_SEATS_ON_SHOW_SHOW FOREIGN KEY (show_show_id) REFERENCES shows (show_id);