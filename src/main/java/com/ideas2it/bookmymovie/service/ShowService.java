package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.ShowDto;
import com.ideas2it.bookmymovie.dto.responseDto.ShowSlimDto;

import java.util.List;

public interface ShowService {

//    ShowDto addShow(ShowDto show, Integer theatreId, Integer screenId);
    ShowSlimDto createShow(ShowDto showDto, int theatreId, int screenId);
    ShowDto updateShow(ShowDto show, Integer theatreId, Integer screenId);

    void removeShow(int showId);

    ShowDto getShowById(int showId);

    List<ShowDto> getAllShow();

    List<ShowDto> getShowByThreatreId(int theatreId);

//    List<ShowDto> getShowByDate(LocalDate date);
}
