CREATE TABLE screen (
  id INT AUTO_INCREMENT NOT NULL,
   no_of_seats INT NOT NULL,
   no_of_rows INT NOT NULL,
   no_of_columns INT NOT NULL,
   theatre_id INT NULL,
   status BIT(1) NULL,
   CONSTRAINT pk_screen PRIMARY KEY (id)
);
CREATE TABLE theatre (
  id INT AUTO_INCREMENT NOT NULL,
   name VARCHAR(255) NULL,
   city_name VARCHAR(255) NULL,
   status BIT(1) NULL,
   CONSTRAINT pk_theatre PRIMARY KEY (id)
);
ALTER TABLE screen ADD CONSTRAINT FK_SCREEN_ON_THEATRE FOREIGN KEY (theatre_id) REFERENCES theatre (id);
CREATE TABLE seat (
  id INT AUTO_INCREMENT NOT NULL,
   seat_no INT NOT NULL,
   seat_type VARCHAR(255) NULL,
   screen_id INT NULL,
   CONSTRAINT pk_seat PRIMARY KEY (id)
);

ALTER TABLE seat ADD CONSTRAINT FK_SEAT_ON_SCREEN FOREIGN KEY (screen_id) REFERENCES screen (id);

CREATE TABLE screening (
  id INT AUTO_INCREMENT NOT NULL,
   movie_id INT NULL,
   date date NULL,
   start_time time NULL,
   screen_id INT NULL,
   CONSTRAINT pk_screening PRIMARY KEY (id)
);
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
ALTER TABLE screening ADD CONSTRAINT FK_SCREENING_ON_MOVIE FOREIGN KEY (movie_id) REFERENCES movie (id);

ALTER TABLE screening ADD CONSTRAINT FK_SCREENING_ON_SCREEN FOREIGN KEY (screen_id) REFERENCES screen (id);
