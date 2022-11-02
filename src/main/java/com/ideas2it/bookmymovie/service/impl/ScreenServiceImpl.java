package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.ScreenDto;
import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Screen;
import com.ideas2it.bookmymovie.model.SeatType;
import com.ideas2it.bookmymovie.model.Theatre;
import com.ideas2it.bookmymovie.model.TimeSlot;
import com.ideas2it.bookmymovie.repository.ScreenRepository;
import com.ideas2it.bookmymovie.service.ScreenService;
import com.ideas2it.bookmymovie.service.SeatTypeService;
import com.ideas2it.bookmymovie.service.TheatreService;
import com.ideas2it.bookmymovie.service.TimeSlotService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScreenServiceImpl implements ScreenService {
    private final ScreenRepository screenRepository;
    private final TheatreService theatreService;
    private final SeatTypeService seatTypeService;
    private final TimeSlotService timeSlotService;
    private final MapStructMapper mapper;

    public ScreenServiceImpl(ScreenRepository screenRepository, TheatreService theatreService,
                             SeatTypeService seatTypeService, TimeSlotService timeSlotService, MapStructMapper mapper) {
        this.screenRepository = screenRepository;
        this.theatreService = theatreService;
        this.seatTypeService = seatTypeService;
        this.timeSlotService = timeSlotService;
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
    public ScreenDto createScreen(ScreenDto screenDto) throws NotFoundException {
        Screen screen = mapper.screenDtoToScreen(screenDto);
        List<SeatType> seatTypes = new ArrayList<>();
        for (SeatType seatType : screen.getSeatTypes()) {
             seatTypes.add(seatTypeService.getSeatTypeBySeatTypeId(seatType.getSeatTypeId()));
        }
        screen.setSeatTypes(seatTypes);
        List<TimeSlot> timeSlots = new ArrayList<>();
        for (TimeSlot timeSlot : screen.getTimeSlots()) {
            timeSlots.add(timeSlotService.getTimeSlotByTimeSlotId(timeSlot.getTimeSlotId()));
        }
        screen.setTimeSlots(timeSlots);
        int theatreId = screenDto.getTheatre().getTheatreId();
        if (0 != theatreId) {
            Theatre theatre = mapper.theatreDtoToTheatre(theatreService.findTheatreById(theatreId));
            screen.setTheatre(theatre);
        }
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
     * @param screenId it contains
     * @return ScreenDto
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
     * <p>
     * This method List all the Theatre Details by screen
     * </p>
     *
     * @param screenId it contains screen id
     * @return TheatreDto
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
        return screenRepository.findByScreenId(screenId);
    }
}
