CREATE TABLE languages (
  id INT AUTO_INCREMENT NOT NULL,
   name VARCHAR(255) NULL,
   CONSTRAINT pk_language PRIMARY KEY (id)
);
CREATE TABLE genre (
  id INT AUTO_INCREMENT NOT NULL,
   name VARCHAR(255) NULL,
   CONSTRAINT pk_genre PRIMARY KEY (id)
);
CREATE TABLE cast (
  id INT AUTO_INCREMENT NOT NULL,
   cast_name VARCHAR(255) NULL,
   `role` VARCHAR(255) NULL,
   CONSTRAINT pk_cast PRIMARY KEY (id)
);
CREATE TABLE movies (
  movie_id INT NOT NULL,
   movie_name VARCHAR(255) NULL,
   duration time NULL,
   release_date date NULL,
   status BIT(1) NULL,
   created_date datetime NULL,
   modified_date datetime NULL,
   CONSTRAINT pk_movies PRIMARY KEY (movie_id)
);
CREATE TABLE movie_language (
  language_id INT NOT NULL,
   movie_id INT NOT NULL
);

ALTER TABLE movie_language ADD CONSTRAINT fk_movlan_on_language FOREIGN KEY (language_id) REFERENCES languages (id);

ALTER TABLE movie_language ADD CONSTRAINT fk_movlan_on_movie FOREIGN KEY (movie_id) REFERENCES movies (movie_id);
CREATE TABLE movie_genre (
  genre_id INT NOT NULL,
   movie_id INT NOT NULL
);

ALTER TABLE movie_genre ADD CONSTRAINT fk_movgen_on_genre FOREIGN KEY (genre_id) REFERENCES genre (id);

ALTER TABLE movie_genre ADD CONSTRAINT fk_movgen_on_movie FOREIGN KEY (movie_id) REFERENCES movies (movie_id);
CREATE TABLE movie_cast (
  cast_id INT NOT NULL,
   movie_id INT NOT NULL
);

ALTER TABLE movie_cast ADD CONSTRAINT fk_movcas_on_cast FOREIGN KEY (cast_id) REFERENCES cast (id);

ALTER TABLE movie_cast ADD CONSTRAINT fk_movcas_on_movie FOREIGN KEY (movie_id) REFERENCES movies (movie_id);

CREATE TABLE users (
  id INT AUTO_INCREMENT NOT NULL,
   user_name VARCHAR(255) NULL,
   email_id VARCHAR(255) NULL,
   contact_number BIGINT NOT NULL,
   password VARCHAR(255) NULL,
   creation_date datetime NULL,
   modified_date datetime NULL,
   status BIT(1) NOT NULL,
   role_id INT NULL,
   CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE roles (
  id INT AUTO_INCREMENT NOT NULL,
   role_type VARCHAR(255) NULL,
   CONSTRAINT pk_roles PRIMARY KEY (id)
);
ALTER TABLE users ADD CONSTRAINT FK_USERS_ON_ROLE FOREIGN KEY (role_id) REFERENCES roles (id);

CREATE TABLE booking (
  id INT AUTO_INCREMENT NOT NULL,
   user_id INT NULL,
   booking_date date NULL,
   booking_status VARCHAR(255) NULL,
   total_cost DOUBLE NOT NULL,
   CONSTRAINT pk_booking PRIMARY KEY (id)
);

ALTER TABLE booking ADD CONSTRAINT FK_BOOKING_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

CREATE TABLE seats (
  id INT AUTO_INCREMENT NOT NULL,
   seat_number VARCHAR(255) NULL,
   type VARCHAR(255) NULL,
   price DOUBLE NOT NULL,
   seat_status VARCHAR(255) NULL,
   booking_id INT NULL,
   status BIT(1) NULL,
   created_date datetime NULL,
   modified_date datetime NULL,
   CONSTRAINT pk_seats PRIMARY KEY (id)
);

ALTER TABLE seats ADD CONSTRAINT FK_SEATS_ON_BOOKING FOREIGN KEY (booking_id) REFERENCES booking (id);

CREATE TABLE booking_seats (
  `id` INT AUTO_INCREMENT NOT NULL,
  `booking_id` INT NULL,
  `seats_id` INT NULL,
  PRIMARY KEY (`id`)
);

ALTER TABLE booking_seats ADD CONSTRAINT uc_booking_seats_seats UNIQUE (seats_id);

ALTER TABLE booking_seats ADD CONSTRAINT fk_boosea_on_booking FOREIGN KEY (booking_id) REFERENCES booking (id);

ALTER TABLE booking_seats ADD CONSTRAINT fk_boosea_on_seat FOREIGN KEY (seats_id) REFERENCES seats (id);