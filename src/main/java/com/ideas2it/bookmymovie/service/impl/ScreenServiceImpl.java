package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.ScreenDto;
import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.exception.ScreenNotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Screen;
import com.ideas2it.bookmymovie.model.Theatre;
import com.ideas2it.bookmymovie.repository.ScreenRepository;
import com.ideas2it.bookmymovie.repository.TheatreRepository;
import com.ideas2it.bookmymovie.service.ScreenService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScreenServiceImpl implements ScreenService {

    private final ScreenRepository screenRepository;

    private final TheatreRepository theatreRepository;

    private final MapStructMapper mapper;

    public ScreenServiceImpl(ScreenRepository screenRepository, TheatreRepository theatreRepository,
                             MapStructMapper mapper) {
        this.screenRepository = screenRepository;
        this.theatreRepository = theatreRepository;
        this.mapper = mapper;
    }


    /**
     * @return screen
     */
    @Override
    public ScreenDto addScreen(ScreenDto screenDto, int theatreId) throws ScreenNotFoundException {
        Screen screen = mapper.screenDtoToScreen(screenDto);
        if (theatreId != 0) {
            Theatre theatre = theatreRepository.findById(theatreId).get();
            screen.setTheatre(theatre);
        }
        return mapper.screenToScreenDto(screenRepository.save(screen));
    }

    /**
     * @return screenList
     */
    @Override
    public List<ScreenDto> viewScreenList() throws ScreenNotFoundException {
        List<Screen> screens = screenRepository.findAllByStatus(true);
        if (screens.isEmpty()) {
            throw new ScreenNotFoundException("No Details Present Here");
        }
        return screens.stream().
                map(screen -> mapper.screenToScreenDto(screen)).collect(Collectors.toList());
    }

    @Override
    public ScreenDto viewScreen(int screenId) throws ScreenNotFoundException {
        Optional<Screen> screen = screenRepository.findById(screenId);
        if(screen.isPresent()){
            return mapper.screenToScreenDto(screen.get());
        }
        throw new ScreenNotFoundException("Screen Id not found");
    }

    /**
     * @return updatedScreen
     */
    @Override
    public ScreenDto updateScreen(int screenId) {
        Optional<Screen> screen = screenRepository.findById(screenId);
        if (screen != null) {
            screen.get().setStatus(false);
            screenRepository.saveAndFlush(screen.get());
        }
        return mapper.screenToScreenDto(screen.get());
    }

    @Override
    public TheatreDto getTheatre(int screenId) throws ScreenNotFoundException {
        Optional<Screen> screen =screenRepository.findById(screenId);
        if(screen.isPresent()) {
            Theatre theatre = screen.get().getTheatre();
            return mapper.theatreToTheatreDto(theatre);
        }
        throw new ScreenNotFoundException("Screen Id not found");
    }
}
