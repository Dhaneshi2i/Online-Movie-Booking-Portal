package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.ScreenDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.model.Screen;
import com.ideas2it.bookmymovie.repository.ScreenRepository;
import com.ideas2it.bookmymovie.service.ScreenService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScreenServiceImpl implements ScreenService {
    private final ModelMapper mapper;
    private final ScreenRepository screenRepository;

    public ScreenServiceImpl(ModelMapper mapper, ScreenRepository screenRepository) {
        this.mapper = mapper;
        this.screenRepository = screenRepository;
    }

    /**
     * This method gets screenDto object as parameter to create Screen Details
     *
     * @param screenDto is passed as argument to add those value to the database.
     */
    public ScreenDto createScreenDetails(ScreenDto screenDto) {
        Screen screen = screenRepository.save(mapper.map(screenDto, Screen.class));
        return mapper.map(screen,ScreenDto.class);
    }

    /**
     * This method List all the Screen Details that are present in Database
     *
     * @return List<ScreenDto> which will have all the Screen Details which are present in
     * the database.
     */
    public List<ScreenDto> listAllScreen() throws NotFoundException {
        System.out.println("screens");
        List<Screen> screens = screenRepository.findAll();
        System.out.println(screens);
        if (screens.isEmpty()) {
            throw new NotFoundException("No Details Present Here");
        }
        return screens.stream().
                map(screen -> (mapper.map(screen, ScreenDto.class))).collect(Collectors.toList());
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
            return mapper.map(screen, ScreenDto.class);
        }
        throw new NotFoundException("No Details are found for this id");
    }
}
