package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.GenreDto;

public interface GenreService {
    GenreDto getGenreByName(String name);
    GenreDto addGenre(GenreDto genreDto);
}
