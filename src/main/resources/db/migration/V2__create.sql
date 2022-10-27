CREATE TABLE theatres (
  theatre_id INT AUTO_INCREMENT NOT NULL,
   theatre_name VARCHAR(255) NULL,
   theatre_city VARCHAR(255) NULL,
   status BIT(1) NOT NULL,
   modified_date datetime NULL,
   created_date datetime NULL,
   CONSTRAINT pk_theatres PRIMARY KEY (theatre_id)
);

CREATE TABLE screens (
  id INT AUTO_INCREMENT NOT NULL,
   theatre_id INT NULL,
   screen_name VARCHAR(255) NULL,
   no_of_rows INT NOT NULL,
   no_of_columns INT NOT NULL,
   status BIT(1) NOT NULL,
   created_date datetime NULL,
   modified_date datetime NULL,
   CONSTRAINT pk_screens PRIMARY KEY (id)
);

ALTER TABLE screens ADD CONSTRAINT FK_SCREENS_ON_THEATRE FOREIGN KEY (theatre_id) REFERENCES theatres (theatre_id);

CREATE TABLE shows (
  show_id INT NOT NULL,
   show_date date NULL,
   show_start_time time NULL,
   show_end_time time NULL,
   movie_id INT NULL,
   screen_id INT NULL,
   theatre_id INT NULL,
   booking_id INT NULL,
   status BIT(1) NULL,
   CONSTRAINT pk_shows PRIMARY KEY (show_id)
);

ALTER TABLE shows ADD CONSTRAINT FK_SHOWS_ON_BOOKING FOREIGN KEY (booking_id) REFERENCES booking (id);

ALTER TABLE shows ADD CONSTRAINT FK_SHOWS_ON_MOVIE FOREIGN KEY (movie_id) REFERENCES movies (movie_id);

ALTER TABLE shows ADD CONSTRAINT FK_SHOWS_ON_SCREEN FOREIGN KEY (screen_id) REFERENCES screens (id);

ALTER TABLE shows ADD CONSTRAINT FK_SHOWS_ON_THEATRE FOREIGN KEY (theatre_id) REFERENCES theatres (theatre_id);