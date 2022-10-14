package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.GenreDto;

import java.util.List;

public interface GenreService {
    GenreDto getGenreByName(String name);
}
