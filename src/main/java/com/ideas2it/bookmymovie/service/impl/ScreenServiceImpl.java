package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.ScreenDto;
import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.dto.responseDto.ScreenSlimDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Screen;
import com.ideas2it.bookmymovie.model.Theatre;
import com.ideas2it.bookmymovie.repository.ScreenRepository;
import com.ideas2it.bookmymovie.service.ScreenService;
import com.ideas2it.bookmymovie.service.TheatreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScreenServiceImpl implements ScreenService {

    private ScreenRepository screenRepository;

    private TheatreService theatreService;

    private MapStructMapper mapper;

    public ScreenServiceImpl(ScreenRepository screenRepository, TheatreService theatreService,
                             MapStructMapper mapper) {
        this.screenRepository = screenRepository;
        this.theatreService = theatreService;
        this.mapper = mapper;
    }


    /**
     * This method gets screenDto object as parameter to create Screen Details
     *
     * @param screenDto is passed as argument to add these value to the database.
     *
     * @return ScreenDto which return the created Screen Details
     */
    @Override
    public ScreenDto createScreen(ScreenDto screenDto, int theatreId) throws NotFoundException {
        Screen screen = mapper.screenDtoToScreen(screenDto);
        if (0 != theatreId) {
            Theatre theatre = mapper.theatreDtoToTheatre(theatreService.findTheatreById(theatreId));
            screen.setTheatre(theatre);
        }
        return mapper.screenToScreenDto(screenRepository.save(screen));
    }

    /**
     * This method List all the Screen Details that are present in Database
     *
     * @return List<ScreenDto> which will have all the Screen Details which are present in
     * the database.
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
     * This method gets screenId as parameter and update the Screen Details
     *
     * @param screenId is passed as argument to get those value from the database.
     * @return List of screen details after update
     */
    @Override
    public ScreenDto updateScreenById(int screenId) throws NotFoundException {
        Optional<Screen> screen = screenRepository.findById(screenId);
        if (screen.isPresent()) {
            screen.get().setStatus(false);
            screenRepository.saveAndFlush(screen.get());
            return mapper.screenToScreenDto(screen.get());
        }
        throw new NotFoundException("Screen with the given id is not present");
    }

    /**
     * This method gets screenId as parameter and get the Screen Details which matches the id
     *
     * @param screenId is passed as argument to fetch those from the database.
     * @return ScreenDto which is fetched from database with the param
     */
    @Override
    public ScreenSlimDto getScreenById(int screenId) throws NotFoundException {
        Optional<Screen> screen = screenRepository.findById(screenId);
        if(screen.isPresent()){
            return mapper.screenToScreenSlimDto(screen.get());
        }
        throw new NotFoundException("Screen Id not found");
    }

    /**
     * This method List all the Theatre Details by screen that are present in Database
     *
     * @param screenId is passed to categorize the screen Details by Movie
     * @return TheatreDto which will have the details of theatre
     * which was categorized by screen
     */
    @Override
    public TheatreDto getTheatreByScreenId(int screenId) throws NotFoundException {
        Optional<Screen> screen =screenRepository.findById(screenId);
        if(screen.isPresent()) {
            Theatre theatre = screen.get().getTheatre();
            return mapper.theatreToTheatreDto(theatre);
        }
        throw new NotFoundException("Screen Id not found");
    }

    public Screen findScreenById(int screenId) {
        return screenRepository.findById(screenId).get();
    }
}
