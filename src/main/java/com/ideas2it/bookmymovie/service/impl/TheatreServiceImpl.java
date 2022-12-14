package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.dto.responseDto.ScreenResponseDto;
import com.ideas2it.bookmymovie.dto.responseDto.TheatreResponseDto;
import com.ideas2it.bookmymovie.exception.AlreadyExistException;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Theatre;
import com.ideas2it.bookmymovie.repository.TheatreRepository;
import com.ideas2it.bookmymovie.service.ScreenService;
import com.ideas2it.bookmymovie.service.TheatreService;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * <p>
 * This {@Code TheatreService} interface used for crud operations
 * </p>
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 */
@Service
public class TheatreServiceImpl implements TheatreService {

    private final TheatreRepository theatreRepository;
    private final ScreenService screenService;
    private final MapStructMapper mapper;

    public TheatreServiceImpl(TheatreRepository theatreRepository, @Lazy ScreenService screenService, MapStructMapper mapper) {
        this.theatreRepository = theatreRepository;
        this.screenService = screenService;
        this.mapper = mapper;
    }

    /**
     * <p>
     * This method is used to create Theatre Details
     * </p>
     *
     * @param theatreDto it contains theatre dto object
     * @return TheatreDto
     */
    @Override
    public TheatreResponseDto createTheatre(TheatreDto theatreDto) {
        Theatre theatre = mapper.theatreDtoToTheatre(theatreDto);
        if (theatreRepository.existsByTheatreName(theatreDto.getTheatreName()) && theatreRepository
                .existsByTheatreCity(theatreDto.getTheatreCity())) {
                throw new AlreadyExistException("This Theatre is already exist in this location ");
        }
        return mapper.theatreToTheatreResponseDto(theatreRepository.save(theatre));
    }

    /**
     * <p>
     * This method List all the Theatre Details
     * </p>
     *
     * @return List<TheatreDto>
     */
    @Override
    public List<TheatreDto> getAllTheatre(int pageNumber, int pageSize) throws NotFoundException {
        List<Theatre> theatres = theatreRepository.findAllByStatus(false);
        if (theatres.isEmpty()) {
            throw new NotFoundException("No Details Present Here");
        }

        Pageable p = PageRequest.of(pageNumber, pageSize);
        Page<Theatre> theatre = theatreRepository.findAll(p);
        return mapper.theatreListToTheatreDtoList(theatre.getContent());
    }

    /**
     * <p>
     * This method gets the Theatre Details which matches the id
     * </p>
     *
     * @param theatreId it contains theatre id
     * @return TheatreDto
     */
    @Override
    public TheatreDto findTheatreById(int theatreId) {
        if (theatreRepository.existsById(theatreId)) {
            Theatre theatre = theatreRepository.findByTheatreId(theatreId);
                return mapper.theatreToTheatreDto(theatre);
        }
        throw new NotFoundException("Theatre details with the given id is not found");

    }

    /**
     * <p>
     * This method update the Theatre Details
     * </p>
     *
     * @param theatreDto it contains theatre details
     * @return List<TheatreDto>
     */
    @Override
    public TheatreDto updateTheatre(TheatreDto theatreDto) {
        if(null == theatreDto) {
            throw new NotFoundException("No theatre found for this id");
        }
        return mapper.theatreToTheatreDto(theatreRepository.save(mapper.theatreDtoToTheatre(theatreDto)));
    }

    /**
     * <p>
     * This method List all the Theatre Details by city name
     * </p>
     *
     * @param city it contains city
     * @return List<TheatreDto>
     */

    @Override
    public List<TheatreDto> findTheatresByLocation(String city) {
        List<Theatre> theatres = theatreRepository.findTheatreByTheatreCity(city);
        if (theatres.isEmpty()) {
            throw new NotFoundException("No theatres were found for this location");
        }
        return mapper.theatreListToTheatreDtoList(theatres);
    }

    /**
     * <p>
     * This methods list all the screens for the theatre
     * </p>
     * @param theatreId it contains theatreId
     * @return List<ScreenResponseDto>
     */
    @Override
    public List<ScreenResponseDto> getScreenByTheatreId(int theatreId) {
        return screenService.getScreenByTheatreId(theatreId);
    }

}
