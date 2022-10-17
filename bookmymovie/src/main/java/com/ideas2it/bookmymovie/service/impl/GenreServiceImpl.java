package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.GenreDto;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Genre;
import com.ideas2it.bookmymovie.repository.GenreRepository;
import com.ideas2it.bookmymovie.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    private final MapStructMapper mapper;

    public GenreDto getGenreByName(String name) {
        Genre genre = genreRepository.findGenreByName(name);

        return mapper.genreToGenreDto(genre);
    }

    @Override
    public GenreDto addGenre(GenreDto genreDto) {
        return mapper.genreToGenreDto(genreRepository.save(mapper.genreDtoToGenre(genreDto)));
    }

}
