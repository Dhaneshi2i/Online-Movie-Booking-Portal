package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.ShowDto;
import com.ideas2it.bookmymovie.dto.responseDto.ShowSlimDto;

import java.time.LocalDate;
import java.util.List;

public interface ShowService {

    ShowDto createShow(ShowDto showDto, int theatreId, int screenId, int movieId);
    ShowDto updateShow(ShowDto show, Integer theatreId, Integer screenId);

    void removeShow(int showId);

    ShowDto getShowById(int showId);

    List<ShowDto> getAllShow();

    List<ShowDto> getShowByTheatreId(int theatreId);

    List<ShowDto> getShowsByDate(LocalDate date);
}
