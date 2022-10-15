package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.model.Theatre;
import com.ideas2it.bookmymovie.repository.TheatreRepository;
import com.ideas2it.bookmymovie.service.TheatreService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TheatreServiceImpl implements TheatreService {
    private final ModelMapper mapper;

    private final TheatreRepository theatreRepository;

    public TheatreServiceImpl(ModelMapper mapper, TheatreRepository theatreRepository) {
        this.mapper = mapper;
        this.theatreRepository = theatreRepository;
    }

    /**
     * This method gets theatreDto object as parameter to create Theatre Details
     *
     * @param theatreDto is passed as argument to add those value to the database.
     */
    public TheatreDto createTheatreDetails(TheatreDto theatreDto) {
        Theatre theatre = theatreRepository.save(mapper.map(theatreDto, Theatre.class));
        return mapper.map(theatre,TheatreDto.class);
    }

    /**
     * This method List all the Theatre Details that are present in Database
     *
     * @return List<TheatreDto> which will have all the Theatre Details which are present in
     * the database.
     */
    public List<TheatreDto> listAllTheatre() throws NotFoundException {
        List<Theatre> theatres = theatreRepository.findAll();
        if (theatres.isEmpty()) {
            throw new NotFoundException("No Details Present Here");
        }
        return theatres.stream().
                map(theatre -> (mapper.map(theatre, TheatreDto.class))).collect(Collectors.toList());
    }


    /**
     * This method gets TheatreDto as parameter and update the Theatre Details
     *
     * @param theatreId is passed as argument to update those value to the database.
     * @return String
     */
    public TheatreDto updateTheatreStatusDetail(int theatreId) throws NotFoundException {
        if(theatreRepository.existsById(theatreId)){
            Theatre theatre = theatreRepository.findById(theatreId).get();
            theatre.setStatus(false);
            theatreRepository.save(theatre);
            return mapper.map(theatre, TheatreDto.class);
        }
        throw new NotFoundException("No Details are found for this id");
    }

    /**
     * This method List all the Theatre Details by City Name that are present in Database
     *
     * @param cityName is passed to categorize the theatre Details by City Name
     * @return List<TheatreDto> which will have the list of all the details of theatre
     * which was categorized by city name
     */
    public List<TheatreDto> ListTheatreByCityName(String cityName) throws NotFoundException {
        List<Theatre> theatres = theatreRepository.findByCityName(cityName);
        if (theatres.isEmpty()) {
            throw new NotFoundException("No Details Present Here");
        }
        return theatres.stream().map(theatre -> (mapper.map(theatre, TheatreDto.class))
        ).collect(Collectors.toList());
    }


}


