CREATE TABLE movie (
  id INT AUTO_INCREMENT NOT NULL,
   movie_name VARCHAR(255) NULL,
   release_date datetime NULL,
   duration time NULL,
   CONSTRAINT pk_movie PRIMARY KEY (id)
);