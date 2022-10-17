package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.ScreenDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Screen;
import com.ideas2it.bookmymovie.repository.ScreenRepository;
import com.ideas2it.bookmymovie.service.ScreenService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScreenServiceImpl implements ScreenService {
    private final MapStructMapper mapper;
    private final ScreenRepository screenRepository;

    public ScreenServiceImpl(MapStructMapper mapper, ScreenRepository screenRepository) {
        this.mapper = mapper;
        this.screenRepository = screenRepository;
    }

    /**
     * This method gets screenDto object as parameter to create Screen Details
     *
     * @param screenDto is passed as argument to add those value to the database.
     */
    public ScreenDto createScreenDetails(ScreenDto screenDto) {
        return mapper.screenToScreenDto(screenRepository.save(mapper.screenDtoToScreen(screenDto)));
    }

    /**
     * This method List all the Screen Details that are present in Database
     *
     * @return List<ScreenDto> which will have all the Screen Details which are present in
     * the database.
     */
    public List<ScreenDto> listAllScreen() throws NotFoundException {
        List<Screen> screens = screenRepository.findAllByStatus(true);
        if (screens.isEmpty()) {
            throw new NotFoundException("No Details Present Here");
        }
        return screens.stream().
                map(screen -> mapper.screenToScreenDto(screen)).collect(Collectors.toList());
    }


    /**
     * This method gets ScreenDto as parameter and update the Screen Details
     *
     * @param screenId is passed as argument to update those value to the database.
     * @return String
     */
    public ScreenDto updateScreenStatusDetail(int screenId,Boolean status) throws NotFoundException {
        if(screenRepository.existsById(screenId)){
            Screen screen = screenRepository.findById(screenId).get();
            screen.setStatus(status);
            screenRepository.save(screen);
            return mapper.screenToScreenDto(screen);
        }
        throw new NotFoundException("No Details are found for this id");
    }
}
