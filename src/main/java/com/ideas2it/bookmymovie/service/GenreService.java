package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.GenreDto;

import java.util.List;

/**
 * <p>
 * This {@Code GenreService} interface used for crud operations
 * </p>
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 */
public interface GenreService {

    /**
     * <p>
     * This method is used to create Genre Details
     * </p>
     *
     * @param genreDto it contains genre dto objects
     * @return GenreDto
     */
    GenreDto addGenre(GenreDto genreDto);

    /**
     * <p>
     * This method gets the Genre Details which matches the id
     * </p>
     *
     * @param genreId it contains genre id
     * @return GenreDto
     */
    GenreDto getByGenreId(int genreId);

    /**
     * <p>
     * This methods returns list of all genres
     * </p>
     * @return List<GenreDto>
     */
    List<GenreDto> getAllGenres();
}
