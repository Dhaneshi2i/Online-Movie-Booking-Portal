CREATE TABLE movie (
  id INT NOT NULL,
   movie_name VARCHAR(255) NULL,
   release_date datetime NULL,
   cast_id INT NOT NULL,
   ` screen_id` INT NOT NULL,
   CONSTRAINT pk_movie PRIMARY KEY (id)
);