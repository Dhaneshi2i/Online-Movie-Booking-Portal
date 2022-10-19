package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.GenreDto;

public interface GenreService {
    GenreDto addGenre(GenreDto genreDto);
    GenreDto getGenreByName(String name);
}
