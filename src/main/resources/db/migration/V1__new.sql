CREATE TABLE theatre (
  id INT AUTO_INCREMENT NOT NULL,
   theatre_name VARCHAR(255) NULL,
   theatre_city VARCHAR(255) NULL,
   status TINYINT(1) DEFAULT true NULL,
   modified_date datetime NULL,
   created_date datetime NULL,
   CONSTRAINT pk_theatre PRIMARY KEY (id)
);

CREATE TABLE screen (
  id INT AUTO_INCREMENT NOT NULL,
   theatre_id INT NULL,
   screen_name VARCHAR(255) NULL,
   no_of_rows INT NOT NULL,
   no_of_columns INT NOT NULL,
   status TINYINT(1) DEFAULT true NULL,
   created_date datetime NULL,
   modified_date datetime NULL,
   CONSTRAINT pk_screen PRIMARY KEY (id)
);

ALTER TABLE screen ADD CONSTRAINT FK_SCREEN_ON_THEATRE FOREIGN KEY (theatre_id) REFERENCES theatre (id);
CREATE TABLE booking (
  id INT AUTO_INCREMENT NOT NULL,
   booking_date date NULL,
   transaction_mode VARCHAR(255) NULL,
   transaction_status VARCHAR(255) NULL,
   total_cost DOUBLE NOT NULL,
   CONSTRAINT pk_booking PRIMARY KEY (id)
);

CREATE TABLE shows (
  show_id INT NOT NULL,
   show_start_time datetime NULL,
   show_end_time datetime NULL,
   screen_id INT NULL,
   theatre_id INT NULL,
   booking_id INT NULL,
   show_date date NULL,
   CONSTRAINT pk_shows PRIMARY KEY (show_id)
);

ALTER TABLE shows ADD CONSTRAINT FK_SHOWS_ON_BOOKING FOREIGN KEY (booking_id) REFERENCES booking (id);

ALTER TABLE shows ADD CONSTRAINT FK_SHOWS_ON_SCREEN FOREIGN KEY (screen_id) REFERENCES screen (id);

ALTER TABLE shows ADD CONSTRAINT FK_SHOWS_ON_THEATRE FOREIGN KEY (theatre_id) REFERENCES theatre (id);