package com.ideas2it.bookmymovie.mapper;

import com.ideas2it.bookmymovie.dto.BookingDto;
import com.ideas2it.bookmymovie.dto.CastDto;
import com.ideas2it.bookmymovie.dto.GenreDto;
import com.ideas2it.bookmymovie.dto.LanguageDto;
import com.ideas2it.bookmymovie.dto.MovieDto;
import com.ideas2it.bookmymovie.dto.RoleDto;
import com.ideas2it.bookmymovie.dto.ScreenDto;
import com.ideas2it.bookmymovie.dto.SeatDto;
import com.ideas2it.bookmymovie.dto.SeatTypeDto;
import com.ideas2it.bookmymovie.dto.ShowDto;
import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.dto.TimeSlotDto;
import com.ideas2it.bookmymovie.dto.UserDto;
import com.ideas2it.bookmymovie.dto.responseDto.BookingResponseDto;
import com.ideas2it.bookmymovie.dto.responseDto.ScreenResponseDto;
import com.ideas2it.bookmymovie.dto.responseDto.SeatResponseDto;
import com.ideas2it.bookmymovie.dto.responseDto.UserResponseDto;
import com.ideas2it.bookmymovie.model.Booking;
import com.ideas2it.bookmymovie.model.Cast;
import com.ideas2it.bookmymovie.model.Genre;
import com.ideas2it.bookmymovie.model.Language;
import com.ideas2it.bookmymovie.model.Movie;
import com.ideas2it.bookmymovie.model.Role;
import com.ideas2it.bookmymovie.model.Screen;
import com.ideas2it.bookmymovie.model.Seat;
import com.ideas2it.bookmymovie.model.SeatType;
import com.ideas2it.bookmymovie.model.Show;
import com.ideas2it.bookmymovie.model.Theatre;
import com.ideas2it.bookmymovie.model.TimeSlot;
import com.ideas2it.bookmymovie.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    Theatre theatreDtoToTheatre(TheatreDto theatreDto);

    TheatreDto theatreToTheatreDto(Theatre theatre);

    List<TheatreDto> theatreListToTheatreDtoList(List<Theatre> theatres);

    Seat seatDtoToSeat(SeatDto seatDto);

    SeatDto seatToSeatDto(Seat seat);

    List<SeatDto> seatListToSeatDtoList(List<Seat> seats);

    ScreenResponseDto screenToScreenResponseDto(Screen screen);

    Screen screenDtoToScreen(ScreenDto screenDto);

    ScreenDto screenToScreenDto(Screen screen);

    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);

    RoleDto roleToRoleDto(Role role);

    Role roleDtoToRole(RoleDto roleDto);

    UserResponseDto userToUserResponseDto(User user);

    BookingDto bookingToBookingDto(Booking booking);

    GenreDto genreToGenreDto(Genre genre);

    Genre genreDtoToGenre(GenreDto genreDto);

    LanguageDto languageToLanguageDto(Language language);

    Language languageDtoToLanguage(LanguageDto languageDto);

    Cast castDtoToCast(CastDto castDto);

    CastDto castToCastDto(Cast cast);

    Movie movieDtoToMovie(MovieDto movieDto);

    MovieDto movieToMovieDto(Movie movie);

    Show showDtoToShow(ShowDto showDto);

    ShowDto showToShowDto(Show show);

    List<ShowDto> showListToShowDtoList(List<Show> show);

    List<ShowDto> showListToShowResponseDtoList(List<Show> shows);

    BookingResponseDto bookingToBookingResponseDto(Booking save);

    Booking bookingDtoToBooking(BookingDto bookingDto);

    List<Seat> seatDtoListToSeatList(List<SeatDto> seats);

    Screen screenResponseDtoToScreen(ScreenResponseDto screen);

    ScreenResponseDto screenDtoTOScreenResponseDto(ScreenDto screenDto);

    SeatType seatTypeDtoToSeatType(SeatTypeDto seatTypeDto);

    SeatTypeDto seatTypeToSeatTypeDto(SeatType seatType);

    List<SeatResponseDto> seatListToSeatResponseDtoList(List<Seat> seats);

    List<ShowDto> showListToShowSlimDtoList(List<Show> shows);

    TimeSlotDto timeSlotToTimeSlotDto(TimeSlot timeSlot);

    TimeSlot timeSlotDtoToTimeSlot(TimeSlotDto timeSlotDto);
}

