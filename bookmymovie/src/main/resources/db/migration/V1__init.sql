CREATE TABLE screen (
  id INT NOT NULL,
   no_of_seats INT NOT NULL,
   no_of_rows INT NOT NULL,
   no_of_columns INT NOT NULL,
   theatre_id INT NULL,
   CONSTRAINT pk_screen PRIMARY KEY (id)
);

ALTER TABLE screen ADD CONSTRAINT FK_SCREEN_ON_THEATRE FOREIGN KEY (theatre_id) REFERENCES theatre (id);
CREATE TABLE theatre (
  id INT NOT NULL,
   name VARCHAR(255) NULL,
   city_name VARCHAR(255) NULL,
   CONSTRAINT pk_theatre PRIMARY KEY (id)
);