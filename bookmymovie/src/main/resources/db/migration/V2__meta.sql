CREATE TABLE movie_language (
  language_id INT NOT NULL,
   movie_id INT NOT NULL
);

ALTER TABLE movie_language ADD CONSTRAINT fk_movlan_on_language FOREIGN KEY (language_id) REFERENCES language (id);

ALTER TABLE movie_language ADD CONSTRAINT fk_movlan_on_movie FOREIGN KEY (movie_id) REFERENCES movie (id);
CREATE TABLE movie_genre (
  genre_id INT NOT NULL,
   movie_id INT NOT NULL
);

ALTER TABLE movie_genre ADD CONSTRAINT fk_movgen_on_genre FOREIGN KEY (genre_id) REFERENCES genre (id);

ALTER TABLE movie_genre ADD CONSTRAINT fk_movgen_on_movie FOREIGN KEY (movie_id) REFERENCES movie (id);
CREATE TABLE movie_cast (
  cast_id INT NOT NULL,
   movie_id INT NOT NULL
);

ALTER TABLE movie_cast ADD CONSTRAINT fk_movcas_on_cast FOREIGN KEY (cast_id) REFERENCES cast (id);

ALTER TABLE movie_cast ADD CONSTRAINT fk_movcas_on_movie FOREIGN KEY (movie_id) REFERENCES movie (id);