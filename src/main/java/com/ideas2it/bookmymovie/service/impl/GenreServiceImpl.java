package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.GenreDto;
import com.ideas2it.bookmymovie.exception.AlreadyExistException;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Genre;
import com.ideas2it.bookmymovie.repository.GenreRepository;
import com.ideas2it.bookmymovie.service.GenreService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * This {@Code GenreService} interface used for crud operations
 * </p>
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 */
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
        Genre genre = mapper.genreDtoToGenre(genreDto);
        if (genreRepository.existsByGenreName(genreDto.getGenreName())) {
            throw new AlreadyExistException("This genre already exists, please provide a different genre ");
        }
        return mapper.genreToGenreDto(genreRepository.save(genre));
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
                .map(mapper::genreToGenreDto)
                .orElseThrow(() -> new NotFoundException("No genre found by name: " + genreId ));
    }

    /**
     * <p>
     * This methods returns list of all genres
     * </p>
     * @return List<GenreDto>
     */
    @Override
    public List<GenreDto> getAllGenres() {
        List<Genre> genres = genreRepository.findAll();
        if (genres.isEmpty()) {
            throw new NotFoundException("No genre details is available");
        }
        return mapper.genreListToGenreDtoList(genres);
    }
}
