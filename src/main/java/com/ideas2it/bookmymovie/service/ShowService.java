package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.model.Show;

import java.time.LocalDate;
import java.util.List;

public interface ShowService {

    Show addShow(Show show, Integer theatreId, Integer screenId);

    Show updateShow(Show show, Integer theatreId, Integer screenId);

    Show removeShow(int showId);

    Show viewShow(int showId);

    List<Show> viewAllShows();

    List<Show> viewShowList(int theatreId);

    List<Show> viewShowList(LocalDate date);
}
