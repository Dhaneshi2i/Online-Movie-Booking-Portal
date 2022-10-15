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
CREATE TABLE genre (
  id BIGINT AUTO_INCREMENT NOT NULL,
   genre_name VARCHAR(255) NULL,
   CONSTRAINT pk_genre PRIMARY KEY (id)
);
CREATE TABLE language (
  id BIGINT AUTO_INCREMENT NOT NULL,
   language VARCHAR(255) NULL,
   CONSTRAINT pk_language PRIMARY KEY (id)
);
CREATE TABLE cast (
  id BIGINT AUTO_INCREMENT NOT NULL,
   cast_name VARCHAR(255) NULL,
   cast_role VARCHAR(255) NULL,
   CONSTRAINT pk_cast PRIMARY KEY (id)
);
CREATE TABLE movie_cast (
  cast_id BIGINT NOT NULL,
   movie_id INT NOT NULL
);

ALTER TABLE movie_cast ADD CONSTRAINT fk_movcas_on_cast FOREIGN KEY (cast_id) REFERENCES cast (id);

ALTER TABLE movie_cast ADD CONSTRAINT fk_movcas_on_movie FOREIGN KEY (movie_id) REFERENCES movie (id);
CREATE TABLE movie_language (
  language_id BIGINT NOT NULL,
   movie_id INT NOT NULL
);

ALTER TABLE movie_language ADD CONSTRAINT fk_movlan_on_language FOREIGN KEY (language_id) REFERENCES language (id);

ALTER TABLE movie_language ADD CONSTRAINT fk_movlan_on_movie FOREIGN KEY (movie_id) REFERENCES movie (id);
CREATE TABLE movie_genre (
  genre_id BIGINT NOT NULL,
   movie_id INT NOT NULL
);

ALTER TABLE movie_genre ADD CONSTRAINT fk_movgen_on_genre FOREIGN KEY (genre_id) REFERENCES genre (id);

ALTER TABLE movie_genre ADD CONSTRAINT fk_movgen_on_movie FOREIGN KEY (movie_id) REFERENCES movie (id);