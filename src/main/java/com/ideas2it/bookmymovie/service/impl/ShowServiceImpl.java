package com.ideas2it.bookmymovie.service.impl;

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

    public ShowServiceImpl(ShowRepository showrepository, TheatreService theatreService, ScreenService screenService) {
        this.showrepository = showrepository;
        this.theatreService = theatreService;
        this.screenService = screenService;
    }

    @Override
    public Show addShow(Show show, Integer theatreId, Integer screenId) {

        if (theatreId != null) {
            show.setTheatre( theatreService.findTheatreById(theatreId));
        }
        if (screenId != null) {
            show.setScreen(screenService.findScreenById(screenId));
        }
        showrepository.saveAndFlush(show);
        return show;
    }

    @Override
    public Show updateShow(Show show, Integer theatreId, Integer screenId) {

        if (theatreId != null) {
            show.setTheatre( theatreService.findTheatreById(theatreId));
        }
        if (screenId != null) {
            show.setScreen(screenService.findScreenById(screenId));
        }
        showrepository.saveAndFlush(show);
        return show;
    }

    @Override
    public Show removeShow(int showid) {
        Show show = showrepository.findById(showid).get();
        show.setStatus(true);
        return show;
    }

    @Override
    public Show getShowById(int showid) {
        return showrepository.findById(showid).get();
    }

    @Override
    public List<Show> getAllShow() {
        return showrepository.findAll();
    }

    @Override
    public List<Show> getShowByThreatre(int theatreid) {
        return showrepository.getAllByTheatreId(theatreid);

    }

    @Override
    public List<Show> getShowByDate(LocalDate date) {
        List<Show> shows = new ArrayList<>();
        for (Show show : showrepository.findAll()) {
            if (show.getShowDate() != null && show.getShowDate().isEqual(date)) {
                shows.add(show);
            }
        }
        return shows;
    }

}

