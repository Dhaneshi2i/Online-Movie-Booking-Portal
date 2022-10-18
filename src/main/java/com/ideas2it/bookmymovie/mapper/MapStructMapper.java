package com.ideas2it.bookmymovie.mapper;

import com.ideas2it.bookmymovie.dto.*;
import com.ideas2it.bookmymovie.model.*;
import com.ideas2it.bookmymovie.slimdto.ScreenSlimDto;
import com.ideas2it.bookmymovie.slimdto.SeatSlimDto;
import com.ideas2it.bookmymovie.slimdto.TheatreSlimDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    TheatreSlimDto theatreToTheatreSlimDto(Theatre theatre);
    Theatre theatreDtoToTheatre(TheatreDto theatreDto);
    TheatreDto theatreToTheatreDto(Theatre theatre);

    SeatSlimDto seatToSeatSlimDto(Seat seat);
    Seat seatDtoToSeat(SeatDto seatDto);
    SeatDto seatToSeatDto(Seat seat);
    ScreenSlimDto screenToScreenSlimDto(Screen screen);
    Screen screenDtoToScreen(ScreenDto screenDto);
    ScreenDto screenToScreenDto(Screen screen);
}
