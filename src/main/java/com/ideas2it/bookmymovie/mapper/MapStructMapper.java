package com.ideas2it.bookmymovie.mapper;

import com.ideas2it.bookmymovie.dto.*;
import com.ideas2it.bookmymovie.model.*;
import com.ideas2it.bookmymovie.slimdto.ScreenSlimDto;
import com.ideas2it.bookmymovie.slimdto.SeatSlimDto;
import com.ideas2it.bookmymovie.slimdto.TheatreSlimDto;
import org.mapstruct.Mapper;

import java.util.List;

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
    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);
    RoleDto roleToRoleDto(Role role);
    Role roleDtoToRole(RoleDto roleDto);
    TicketDto ticketToTicketDto(Ticket ticket);
    Ticket ticketDtoToTicket(TicketDto ticketDto);
    BookingDto bookingToBookingDto(Booking booking);
    Booking bookingDtoToBooking(BookingDto bookingDto);
    GenreDto genreToGenreDto(Genre genre);
    Genre genreDtoToGenre(GenreDto genreDto);
    LanguageDto languageToLanguageDto(Language language);
    Language languageDtoToLanguage(LanguageDto languageDto);
    Cast castDtoToCast(CastDto castDto);
    CastDto castToCastDto(Cast cast);
    List<BookingDto> bookingListToBookingDtoList(List<Booking> bookings);
}