package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.ScreenDto;
import com.ideas2it.bookmymovie.dto.responseDto.ScreenResponseDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Screen;
import com.ideas2it.bookmymovie.model.Theatre;
import com.ideas2it.bookmymovie.repository.ScreenRepository;
import com.ideas2it.bookmymovie.service.ScreenService;
import com.ideas2it.bookmymovie.service.TheatreService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * This {@Code ScreenServiceImpl} interface used for crud operations
 * </p>
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 */
@Service
public class ScreenServiceImpl implements ScreenService {
    private final ScreenRepository screenRepository;
    private final TheatreService theatreService;
    private final MapStructMapper mapper;

    public ScreenServiceImpl(ScreenRepository screenRepository, TheatreService theatreService, MapStructMapper mapper) {
        this.screenRepository = screenRepository;
        this.theatreService = theatreService;
        this.mapper = mapper;
    }


    /**
     * <p>
     * This method is used to create Screen Details
     * </p>
     *
     * @param screenDto it contains screen dto object
     * @return ScreenDto
     */
    @Override
    public ScreenDto createScreen(ScreenDto screenDto)  {
        Screen screen = mapper.screenDtoToScreen(screenDto);
        int theatreId = screenDto.getTheatre().getId();

        if (0 == theatreId) {
            throw new NotFoundException("No theatre id is provided");
        }
        Theatre theatre = mapper.theatreDtoToTheatre(theatreService.findTheatreById(theatreId));
        screen.setTheatre(theatre);
        screen.setSeatTypes(mapper.seatTypeDtoListToSeatTypeList(screenDto.getSeatTypes()));
        return mapper.screenToScreenDto(screenRepository.save(screen));
    }

    /**
     * <p>
     * This method List all the Screen Details
     * </p>
     *
     * @return List<ScreenDto>
     */
    @Override
    public List<ScreenDto> getAllScreen() throws NotFoundException {
        List<Screen> screens = screenRepository.findAllByStatus(false);

        if (screens.isEmpty()) {
            throw new NotFoundException("No Details Present Here");
        }
        return screens.stream().
                map(mapper::screenToScreenDto).collect(Collectors.toList());
    }

    /**
     * <p>
     * This method updates the Screen Details
     * </p>
     *
     * @param screenDto it contains
     * @return ScreenDto
     */
    @Override
    public ScreenDto updateScreen(ScreenDto screenDto){
        if (null == screenDto) {
            throw new NotFoundException("No Screen details is present");
        }
        return mapper.screenToScreenDto(screenRepository.save(mapper.screenDtoToScreen(screenDto)));
    }

    /**
     * <p>
     * This method gets the Screen Details which matches the id
     * </p>
     *
     * @param screenId it contains screen id
     * @return ScreenDto
     */
    @Override
    public ScreenDto getScreenById(int screenId)  {
        Screen screen = screenRepository.findByScreenId(screenId);
        if (null == screen) {
            throw new NotFoundException("Screen Id not found");
        } else {
            return mapper.screenToScreenDto(screen);
        }
    }

    /**
     * This method List all the screen details by theatre that are present in Database
     *
     * @param theatreId is passed to categorize the screen Details by Movie
     * @return List<ScreenResponseDto>
     */
    @Override
    public List<ScreenResponseDto> getScreenByTheatreId(int theatreId) {
        List<Screen> screens = new ArrayList<>();
        for (Screen screen : screenRepository.findAll()) {
            if (screen.getTheatre().getTheatreId() == theatreId) {
                screens.add(screen);
            }
        }
        return mapper.screenListToScreenResponseDtoList(screens);
    }
}
