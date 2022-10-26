package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.ShowDto;
import com.ideas2it.bookmymovie.dto.responseDto.ShowSlimDto;
import com.ideas2it.bookmymovie.model.Show;

import java.util.List;

public interface ShowService {

//    ShowDto addShow(ShowDto show, Integer theatreId, Integer screenId);
    ShowSlimDto createShow(ShowDto showDto, int theatreId, int screenId, int movieId);
    ShowDto updateShow(ShowDto show, Integer theatreId, Integer screenId);

    ShowDto updateShow(Show show);

    void removeShow(int showId);

    ShowDto getShowById(int showId);

    List<ShowDto> getAllShow();

    List<ShowDto> getShowByTheatreId(int theatreId);

//    List<ShowDto> getShowByDate(LocalDate date);
}
