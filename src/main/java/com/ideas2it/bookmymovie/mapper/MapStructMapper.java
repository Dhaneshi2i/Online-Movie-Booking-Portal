package com.ideas2it.bookmymovie.mapper;

import com.ideas2it.bookmymovie.dto.*;
import com.ideas2it.bookmymovie.model.*;
import com.ideas2it.bookmymovie.slimdto.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    TheatreSlimDto theatreToTheatreSlimDto(Theatre theatre);
    Theatre theatreDtoToTheatre(TheatreDto theatreDto);
    TheatreDto theatreToTheatreDto(Theatre theatre);
    List<TheatreDto> theatreListToTheatreDtoList(List<Theatre> theatres);
    SeatSlimDto seatToSeatSlimDto(Seat seat);
    Seat seatDtoToSeat(SeatDto seatDto);
    SeatDto seatToSeatDto(Seat seat);
    List<SeatDto> seatListToSeatDtoList(List<Seat> seats);
    ScreenSlimDto screenToScreenSlimDto(Screen screen);
    Screen screenDtoToScreen(ScreenDto screenDto);
    ScreenDto screenToScreenDto(Screen screen);
    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);
    RoleSlimDto roleToRoleSlimDto(Role role);
    RoleDto roleToRoleDto(Role role);
    UserSlimDto userToUserSlimDto (User user);
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

    List<Ticket> ticketsDtoListToTicketsList(List<TicketDto> tickets);
    List<TicketDto> ticketsListToTicketsDtoList(List<Ticket> tickets);
    ShowSlimDto showToShowSlimDto(Show show);

    Movie movieDtoToMovie(MovieDto movieDto);
    MovieDto movieToMovieDto(Movie movie);

    Show showDtoToShow(ShowDto showDto);
    ShowDto showToShowDto(Show show);

    MovieSlimDto movieToMovieSlimDto(Movie movie);

    List<ShowDto> showListToShowDtoList(List<Show> show);
    List<Show> showDtoListToShowList(List<ShowDto> showDto);



}
