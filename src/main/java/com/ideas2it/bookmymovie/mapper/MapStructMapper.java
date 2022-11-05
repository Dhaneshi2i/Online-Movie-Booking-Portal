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
import com.ideas2it.bookmymovie.dto.responseDto.BookingCancelledResponseDto;
import com.ideas2it.bookmymovie.dto.responseDto.BookingResponseDto;
import com.ideas2it.bookmymovie.dto.responseDto.ScreenResponseDto;
import com.ideas2it.bookmymovie.dto.responseDto.SeatResponseDto;
import com.ideas2it.bookmymovie.dto.responseDto.ShowResponseDto;
import com.ideas2it.bookmymovie.dto.responseDto.TheatreResponseDto;
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
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    @Mapping(target = "userId",source = "id")
    User userDtoToUser(UserDto userDto);
    @Mapping(target = "id",source = "userId")
    UserDto userToUserDto(User user);
    @Mapping(target = "id",source = "timeSlotId")
    TimeSlotDto timeSlotToTimeSlotDto(TimeSlot timeSlot);
    @Mapping(target = "timeSlotId",source = "id")
    TimeSlot timeSlotDtoToTimeSlot(TimeSlotDto timeSlotDto);
    @Mapping(target = "theatreId",source = "id")
    Theatre theatreDtoToTheatre(TheatreDto theatreDto);
    @Mapping(target = "id",source = "theatreId")
    TheatreDto theatreToTheatreDto(Theatre theatre);
    @Mapping(target = "id",source = "roleId")
    RoleDto roleToRoleDto(Role role);
    @Mapping(target = "roleId",source = "id")
    Role roleDtoToRole(RoleDto roleDto);
    @Mapping(target = "screenId",source = "id")
    Screen screenDtoToScreen(ScreenDto screenDto);
    @Mapping(target = "movieId",source = "id")
    Movie movieDtoToMovie(MovieDto movieDto);
    @Mapping(target = "id",source = "screenId")
    ScreenDto screenToScreenDto(Screen screen);
    @Mapping(target = "id",source = "showId")
    ShowDto showToShowDto(Show show);
    @Mapping(target = "id",source = "seatTypeId")
    SeatTypeDto seatTypeToSeatTypeDto(SeatType seatType);
    @Mapping(target = "seatTypeId",source = "id")
    SeatType seatTypeDtoToSeatType(SeatTypeDto seatTypeDto);
    @Mapping(target = "castId",source = "id")
    Cast castDtoToCast(CastDto castDto);
    @Mapping(target = "id",source = "castId")
    CastDto castToCastDto(Cast cast);
    @Mapping(target = "genreId",source = "id")
    Genre genreDtoToGenre(GenreDto genreDto);
    @Mapping(target = "id",source = "genreId")
    GenreDto genreToGenreDto(Genre genre);
    @Mapping(target = "languageId",source = "id")
    Language languageDtoToLanguage(LanguageDto languageDto);
    @Mapping(target = "id",source = "languageId")
    LanguageDto languageToLanguageDto(Language language);
    @Mapping(target = "id",source = "movieId")
    MovieDto movieToMovieDto(Movie movie);
    @Mapping(target = "id",source = "seatId")
    SeatDto seatToSeatDto(Seat seat);
    @Mapping(target = "id", source = "showId")
    ShowResponseDto showToShowResponseDto(Show show);
    @Mapping(target = "id",source = "seatId")
    SeatResponseDto seatToSeatResponseDto(Seat seat);
    @Mapping(target = "id",source = "userId")
    UserResponseDto userToUserResponseDto(User user);
    @Mapping(target = "id",source = "screenId")
    ScreenResponseDto screenToScreenResponseDto(Screen screen);
    Show showResponseDtoToShow(ShowResponseDto showResponseDto);
    BookingResponseDto bookingToBookingResponseDto(Booking booking);
    TheatreResponseDto theatreToTheatreResponseDto(Theatre theatre);
    BookingCancelledResponseDto bookingToBookingCancelledResponseDto(Booking booking);
    List<SeatType> seatTypeDtoListToSeatTypeList(List<SeatTypeDto> seatTypes);
    List<TheatreDto> theatreListToTheatreDtoList(List<Theatre> theatres);
    List<BookingDto> bookingListToBookingDtoList(List<Booking> bookings);
    List<UserResponseDto> userListToUserDtoList(List<User> users);
    List<CastDto> castListToCastDtoList(List<Cast> casts);
    List<GenreDto> genreListToGenreDtoList(List<Genre> genres);
    List<LanguageDto> languageListToLanguageDtoList(List<Language> languages);
    List<MovieDto> movieListToMovieDtoList(List<Movie> movies);
    List<SeatDto> seatListToSeatDtoList(List<Seat> seats);
    List<SeatResponseDto> seatListToSeatResponseDtoList(List<Seat> seats);
    List<SeatTypeDto> seatTypeListToSeatTypeDtoList(List<SeatType> all);
    List<ShowResponseDto> showListToShowResponseDtoList(List<Show> shows);

    List<ScreenDto> screenListToScreenDtoList(List<Screen> screens);

    List<ScreenResponseDto> screenListToScreenResponseDtoList(List<Screen> screens);

    List<BookingResponseDto> bookingListToBookingResponseList(List<Booking> bookings);
}

