CREATE TABLE movie (
  id INT AUTO_INCREMENT NOT NULL,
   movie_name VARCHAR(255) NULL,
   release_date date NULL,
   duration VARCHAR(255) NULL,
   status BIT(1) NULL,
   created_date date NULL,
   modified_date date NULL,
   CONSTRAINT pk_movie PRIMARY KEY (id)
);
CREATE TABLE genre (
  id INT AUTO_INCREMENT NOT NULL,
   genre_name VARCHAR(255) NULL,
   CONSTRAINT pk_genre PRIMARY KEY (id)
);
CREATE TABLE cast (
  id INT AUTO_INCREMENT NOT NULL,
   cast_name VARCHAR(255) NULL,
   cast_role VARCHAR(255) NULL,
   CONSTRAINT pk_cast PRIMARY KEY (id)
);
CREATE TABLE language (
  id INT AUTO_INCREMENT NOT NULL,
   language VARCHAR(255) NULL,
   CONSTRAINT pk_language PRIMARY KEY (id)
);