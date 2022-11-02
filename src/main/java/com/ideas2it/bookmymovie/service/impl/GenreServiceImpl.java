package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.GenreDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.repository.GenreRepository;
import com.ideas2it.bookmymovie.service.GenreService;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;
    private final MapStructMapper mapper;

    public GenreServiceImpl(GenreRepository genreRepository, MapStructMapper mapper) {
        this.genreRepository = genreRepository;
        this.mapper = mapper;
    }

    /**
     * <p>
     * This method is used to create Genre Details
     * </p>
     *
     * @param genreDto it contains genre dto objects
     * @return GenreDto
     */
    @Override
    public GenreDto addGenre(GenreDto genreDto) {
        return mapper.genreToGenreDto(genreRepository.save(mapper.genreDtoToGenre(genreDto)));
    }

    /**
     * <p>
     * This method gets the Genre Details which matches the id
     * </p>
     *
     * @param genreId it contains genre id
     * @return GenreDto
     */
    @Override
    public GenreDto  getByGenreId (int genreId) {
        return genreRepository.findByGenreId(genreId)
                .map(genre -> mapper.genreToGenreDto(genre))
                .orElseThrow(() -> new NotFoundException("No genre found by name: " + genreId ));
    }
}
