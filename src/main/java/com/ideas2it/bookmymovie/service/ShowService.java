package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.ShowDto;
import com.ideas2it.bookmymovie.model.Show;

import java.time.LocalDate;
import java.util.List;

public interface ShowService {

    ShowDto addShow(ShowDto show, Integer theatreId, Integer screenId);

    ShowDto updateShow(ShowDto show, Integer theatreId, Integer screenId);

    void removeShow(int showId);

    ShowDto getShowById(int showId);

    List<ShowDto> getAllShow();

    List<ShowDto> getShowByThreatre(int theatreId);

//    List<ShowDto> getShowByDate(LocalDate date);
}
