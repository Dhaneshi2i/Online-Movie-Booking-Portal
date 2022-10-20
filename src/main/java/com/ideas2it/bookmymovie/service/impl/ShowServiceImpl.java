package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.model.Screen;
import com.ideas2it.bookmymovie.model.Show;
import com.ideas2it.bookmymovie.model.Theatre;
import com.ideas2it.bookmymovie.repository.ScreenRepository;
import com.ideas2it.bookmymovie.repository.ShowRepository;
import com.ideas2it.bookmymovie.repository.TheatreRepository;
import com.ideas2it.bookmymovie.service.ShowService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {
    private ShowRepository showrepository;

    private TheatreRepository theatreRepository;

    private ScreenRepository screenRepository;

    public ShowServiceImpl(ShowRepository showrepository, TheatreRepository theatreRepository, ScreenRepository screenRepository) {
        this.showrepository = showrepository;
        this.theatreRepository = theatreRepository;
        this.screenRepository = screenRepository;
    }

    @Override
    public Show addShow(Show show, Integer theatreId, Integer screenId) {

        if (theatreId != null) {
            Theatre theatre = theatreRepository.findById(theatreId).get();
            show.setTheatre(theatre);
        }
        if (screenId != null) {
            Screen screen = screenRepository.findById(screenId).get();
            show.setScreen(screen);
        }
        showrepository.saveAndFlush(show);
        return show;
    }

    @Override
    public Show updateShow(Show show, Integer theatreId, Integer screenId) {
        Theatre theatre = new Theatre();
        Screen screen = new Screen();
        if (theatreId != null) {
            theatre = theatreRepository.findById(theatreId).get();
            show.setTheatre(theatre);
        }
        if (screenId != null) {
            screen = screenRepository.findById(screenId).get();
            show.setScreen(screen);
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

