package com.ideas2it.bookmymovie.service;

public interface ShowService {

    Show addShow(Show show, Integer theatreId, Integer screenId);

    Show updateShow(Show show, Integer theatreId, Integer screenId);

    Show removeShow(int showId);

    Show getShowById(int showId);

    List<Show> getAllShow();

    List<Show> getShowByThreatre(int theatreId);

    List<Show> getShowByDate(LocalDate date);
}
