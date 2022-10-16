package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.GenreDto;
import com.ideas2it.bookmymovie.model.Genre;
import com.ideas2it.bookmymovie.repository.GenreRepository;
import com.ideas2it.bookmymovie.service.GenreService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;
    private final ModelMapper mapper;
    @Override
    public GenreDto getGenreByName(String name) {
        Genre genre = genreRepository.findGenreByName(name);

        return mapper.map(genre, GenreDto.class);
    }
    @Override
    public GenreDto addGenre(GenreDto genreDto) {
        return mapper.map(genreRepository.save(mapper.map(genreDto, Genre.class)), GenreDto.class);
    }

}
