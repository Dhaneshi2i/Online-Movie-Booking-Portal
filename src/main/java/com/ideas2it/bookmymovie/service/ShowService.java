package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.ShowDto;

import java.time.LocalDate;
import java.util.List;

public interface ShowService {

    ShowDto createShow(ShowDto showDto);
    ShowDto updateShow(ShowDto show, Integer theatreId, Integer screenId);

    void removeShow(int showId);

    ShowDto getShowById(int showId);

    List<ShowDto> getAllShow();

    List<ShowDto> getShowByTheatreId(int theatreId);

    List<ShowDto> getShowsByDate(LocalDate date);
}
