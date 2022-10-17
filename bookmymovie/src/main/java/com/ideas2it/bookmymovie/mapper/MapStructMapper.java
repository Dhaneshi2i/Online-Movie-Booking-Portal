package com.ideas2it.bookmymovie.mapper;

import com.ideas2it.bookmymovie.dto.*;
import com.ideas2it.bookmymovie.model.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    Users usersDtoToUsers(UsersDto usersDto);
    UsersDto usersToUsersDto(Users users);
    Theatre theatreDtoToTheatre(TheatreDto theatreDto);
    TheatreDto theatreToTheatreDto(Theatre theatre);
    Seat seatDtoToSeat(SeatDto seatDto);
    SeatDto seatToSeatDto(Seat seat);
    Screen screenDtoToScreen(ScreenDto screenDto);
    ScreenDto screenToScreenDto(Screen screen);
    Screening screeningDtoToScreening(ScreeningDto screeningDto);
    ScreeningDto screeningToScreeningDto(Screening screening);
    Role roleDtoToRole(RoleDto roleDto);
    RoleDto roleToRoleDto(Role role);
    Movie movieDtoToMovie(MovieDto movieDto);
    MovieDto movieToMovieDto(Movie Movie);
    Language languageDtoToLanguage(LanguageDto languageDto);
    LanguageDto languageToLanguageDto(Language language);
    Genre genreDtoToGenre(GenreDto genreDto);
    GenreDto genreToGenreDto(Genre genre);
    Cast castDtoToCast(CastDto castDto);
    CastDto castToCastDto (Cast cast);
    Booking bookingDtoToBooking(BookingDto bookingDto);
    BookingDto bookingToBookingDto(Booking booking);
    BookedSeat bookedSeatDtoToBookedSeat(BookedSeatDto bookedSeatDto);
    BookedSeatDto bookedSeatToBookedSeatDto(BookedSeat bookedSeat);
}
