package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.GenreDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.repository.GenreRepository;
import com.ideas2it.bookmymovie.service.GenreService;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {
    private GenreRepository genreRepository;
    private MapStructMapper mapper;



    @Override
    public GenreDto addGenre(GenreDto genreDto) {
        return mapper.genreToGenreDto(genreRepository.save(mapper.genreDtoToGenre(genreDto)));
    }

    @Override
    public GenreDto getGenreByName(String name) {
        return genreRepository.findByGenreName(name).map(genre -> mapper.genreToGenreDto(genre))
                .orElseThrow(() -> new NotFoundException("No genre found by name: " + name ));
    }
}
