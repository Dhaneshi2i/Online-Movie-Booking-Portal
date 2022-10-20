package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.ShowDto;
import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Show;
import com.ideas2it.bookmymovie.repository.ShowRepository;
import com.ideas2it.bookmymovie.service.ScreenService;
import com.ideas2it.bookmymovie.service.ShowService;
import com.ideas2it.bookmymovie.service.TheatreService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {
    private ShowRepository showrepository;

    private TheatreService theatreService;

    private ScreenService screenService;
    private MapStructMapper mapper;

    public ShowServiceImpl(ShowRepository showrepository, TheatreService theatreService, ScreenService screenService, MapStructMapper mapper) {
        this.showrepository = showrepository;
        this.theatreService = theatreService;
        this.screenService = screenService;
        this.mapper = mapper;
    }

    @Override
    public ShowDto addShow(ShowDto showDto, Integer theatreId, Integer screenId) {

        if (theatreId != null) {

            showDto.setTheatre(mapper.theatreToTheatreDto(theatreService.findTheatreById(theatreId)));
        }
        if (screenId != null) {
            showDto.setScreen(mapper.screenToScreenDto(screenService.findScreenById(screenId)));
        }
        Show show = mapper.showDtoToShow(showDto);
        showDto = mapper.showToShowDto(showrepository.saveAndFlush(show));
        return showDto;
    }

    @Override
    public ShowDto updateShow(ShowDto showDto, Integer theatreId, Integer screenId) {

        if (theatreId != null) {
            showDto.setTheatre(mapper.theatreToTheatreDto(theatreService.findTheatreById(theatreId)));
        }
        if (screenId != null) {
            showDto.setScreen(mapper.screenToScreenDto(screenService.findScreenById(screenId)));
        }

        Show show = mapper.showDtoToShow(showDto);
        showDto = mapper.showToShowDto(showrepository.saveAndFlush(show));
        return showDto;
    }

    @Override
    public void removeShow(int showid) {
        Show show = showrepository.findById(showid).get();
        show.setStatus(true);

    }

    @Override
    public ShowDto getShowById(int showid) {
        return mapper.showToShowDto(showrepository.findById(showid).get());
    }

    @Override
    public List<ShowDto> getAllShow() {

        return mapper.showListToShowDtoList(showrepository.findAll());
    }

    @Override
    public List<ShowDto> getShowByThreatre(int theatreid) {
        return mapper.showListToShowDtoList(showrepository.getAllByTheatreId(theatreid));

    }

//    @Override
//    public List<ShowDto> getShowByDate(LocalDate date) {
//        List<Show> shows = new ArrayList<>();
//        for (Show show : showrepository.findAll()) {
//            if (show.getShowDate() != null && show.getShowDate().isEqual(date)) {
//                shows.add(show);
//            }
//        }
//        return showsDto;
//    }

}

