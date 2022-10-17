package com.ideas2it.bookmymovie.mapper.impl;

import com.ideas2it.bookmymovie.dto.*;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.BookedSeat;
import com.ideas2it.bookmymovie.model.Booking;
import com.ideas2it.bookmymovie.model.Cast;
import com.ideas2it.bookmymovie.model.Genre;
import com.ideas2it.bookmymovie.model.Language;
import com.ideas2it.bookmymovie.model.Movie;
import com.ideas2it.bookmymovie.model.Role;
import com.ideas2it.bookmymovie.model.Screen;
import com.ideas2it.bookmymovie.model.Screening;
import com.ideas2it.bookmymovie.model.Seat;
import com.ideas2it.bookmymovie.model.Theatre;
import com.ideas2it.bookmymovie.model.Users;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

import org.springframework.stereotype.Component;


@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2022-10-17T14:36:37+0530",
        comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_251 (Oracle Corporation)"
)
@Component
public class MapStructMapperImpl implements MapStructMapper {

    @Override
    public Users usersDtoToUsers(UsersDto usersDto) {
        Users users = new Users();
        if (usersDto != null) {
            users.setUserId(usersDto.getUserId());
            users.setName(usersDto.getName());
            users.setEmailId(usersDto.getEmailId());
            users.setContactNumber(usersDto.getContactNumber());
            users.setPassword(usersDto.getPassword());
            users.setCreationDate(usersDto.getCreationDate());
            users.setModifiedDate(usersDto.getModifiedDate());
            users.setStatus(usersDto.isStatus());
            RoleDto roleDto = usersDto.getRole();
            Role role = new Role();
            if (roleDto != null) {
                if (role.getRoleId() != 0) {
                    role.setRoleId(roleDto.getRoleId());
                }
                role.setRoleType(roleDto.getRoleType());
                List<UsersDto> usersDtoList = roleDto.getUsers();
                List<Users> usersList = new ArrayList<>();
                for(UsersDto userDto : usersDtoList) {
                    Users user = new Users();
                    if (usersDto != null) {
                        user.setUserId(userDto.getUserId());
                        user.setName(userDto.getName());
                        usersList.add(user);
                    }
                    role.setUsers(usersList);
                }
            }
            users.setRole(role);
        }
        return users;
    }

    @Override
    public UsersDto usersToUsersDto(Users users) {
        UsersDto usersDto = new UsersDto();
        return usersDto;
    }

    @Override
    public Theatre theatreDtoToTheatre(TheatreDto theatreDto) {
        Theatre theatre = new Theatre();
        return theatre;
    }

    @Override
    public TheatreDto theatreToTheatreDto(Theatre theatre) {
        TheatreDto theatreDto = new TheatreDto();
        return theatreDto;
    }

    @Override
    public Seat seatDtoToSeat(SeatDto seatDto) {
        Seat seat = new Seat();
        return seat;
    }

    @Override
    public SeatDto seatToSeatDto(Seat seat) {
        SeatDto seatDto = new SeatDto();
        if (seat != null) {
            return null;
        }
        return seatDto;
    }

    @Override
    public Screen screenDtoToScreen(ScreenDto screenDto) {
        return screen;
    }

    @Override
    public ScreenDto screenToScreenDto(Screen screen) {
        return screenDto;
    }

    @Override
    public Screening screeningDtoToScreening(ScreeningDto screeningDto) {
        Screening screening = new Screening();
        if (screeningDto != null) {
            screening.setScreeningId(screeningDto.getScreeningId());
            screening.setMovie(movieDtoToMovie(screeningDto.getMovie()));
            screening.setShowDate(screeningDto.getShowDate());
            screening.setStartTime(screeningDto.getStartTime());

            List<BookedSeat> bookedSeats = new ArrayList<>();
            List<BookedSeatDto> bookedSeatDtos = screeningDto.getBookedSeats();
            for (BookedSeatDto bookedSeatDto : bookedSeatDtos) {
                BookedSeat bookedSeat = new BookedSeat();
                if (bookedSeatDto != null) {
                    if (bookedSeatDto.getBookedSeatId() != 0) {
                        bookedSeat.setBookedSeatId(bookedSeatDto.getBookedSeatId());
                    }
//                bookedSeat.set(screenDto.getNoOfSeats());
//                bookedSeat.setNoOfRows(screenDto.getNoOfRows());
//                bookedSeat.setNoOfColumns(screenDto.getNoOfColumns());
                    bookedSeats.add(bookedSeat);
                }
                screening.setBookedSeats(bookedSeats);
            }

            screening.setBookings(bookingDtoListToBookingList(screeningDto.getBookings()));

            ScreenDto screenDto = screeningDto.getScreen();
            if (screenDto != null) {
                Screen screen = new Screen();
                screen.setScreenId(screenDto.getScreenId());
                screen.setNoOfSeats(screenDto.getNoOfSeats());
                screen.setNoOfRows(screenDto.getNoOfRows());
                screen.setNoOfColumns(screenDto.getNoOfColumns());
                screening.setScreen(screen);
            }
        }
        return screening;
    }

    @Override
    public ScreeningDto screeningToScreeningDto(Screening screening) {
        ScreeningDto screeningDto = new ScreeningDto();
        if (screening != null) {
            screeningDto.setScreeningId(screening.getScreeningId());
            screeningDto.setMovie(movieToMovieDto(screening.getMovie()));
            screeningDto.setShowDate(screening.getShowDate());
            screeningDto.setStartTime(screening.getStartTime());

            List<BookedSeat> bookedSeats = new ArrayList<>();
            List<BookedSeatDto> bookedSeatDtos = screeningDto.getBookedSeats();
            for (BookedSeatDto bookedSeatDto : bookedSeatDtos) {
                BookedSeat bookedSeat = new BookedSeat();
                if (bookedSeatDto != null) {
                    if (bookedSeatDto.getBookedSeatId() != 0) {
                        bookedSeat.setBookedSeatId(bookedSeatDto.getBookedSeatId());
                    }
//                bookedSeat.set(screenDto.getNoOfSeats());
//                bookedSeat.setNoOfRows(screenDto.getNoOfRows());
//                bookedSeat.setNoOfColumns(screenDto.getNoOfColumns());
                    bookedSeats.add(bookedSeat);
                }
                screening.setBookedSeats(bookedSeats);
            }

            screeningDto.setBookings(bookingListToBookingDtoList(screening.getBookings()));

            Screen screen = screening.getScreen();
            if (screen != null) {
                ScreenDto screenDto = new ScreenDto();
                screenDto.setScreenId(screen.getScreenId());
                screenDto.setNoOfSeats(screen.getNoOfSeats());
                screenDto.setNoOfRows(screen.getNoOfRows());
                screenDto.setNoOfColumns(screen.getNoOfColumns());
                screeningDto.setScreen(screenDto);
            }
        }
        return screeningDto;
    }

    @Override
    public Role roleDtoToRole(RoleDto roleDto) {
        Role role = new Role();
        if (roleDto != null) {
            role.setRoleId(roleDto.getRoleId());
            role.setRoleType(roleDto.getRoleType());
            List<UsersDto> usersDtoList = roleDto.getUsers();
            List<Users> usersList = new ArrayList<>();
            for(UsersDto usersDto : usersDtoList){
                Users users =  new Users();
                if (usersDto != null) {
                    users.setUserId(usersDto.getUserId());
                    users.setName(usersDto.getName());
                    users.setEmailId(usersDto.getEmailId());
                    users.setContactNumber(usersDto.getContactNumber());
                    users.setPassword(usersDto.getPassword());
                    users.setCreationDate(usersDto.getCreationDate());
                    users.setModifiedDate(usersDto.getModifiedDate());
                    users.setStatus(usersDto.isStatus());
                    usersList.add(users);
                }
                role.setUsers(usersList);
            }
        }
        return role;
    }

    @Override
    public RoleDto roleToRoleDto(Role role) {
        RoleDto roleDto = new RoleDto();
        if (role != null) {
            roleDto.setRoleId(role.getRoleId());
            roleDto.setRoleType(role.getRoleType());
            List<Users> usersList = role.getUsers();
            List<UsersDto> usersDtoList = new ArrayList<>();
            for(Users users : usersList){
                UsersDto usersDto =  new UsersDto();
                if (users != null) {
                    usersDto.setUserId(users.getUserId());
                    usersDto.setName(users.getName());
                    usersDto.setEmailId(users.getEmailId());
                    usersDto.setContactNumber(users.getContactNumber());
                    usersDto.setPassword(users.getPassword());
                    usersDto.setCreationDate(users.getCreationDate());
                    usersDto.setModifiedDate(users.getModifiedDate());
                    usersDto.setStatus(users.isStatus());
                    usersDtoList.add(usersDto);
                }
                roleDto.setUsers(usersDtoList);
            }
        }
        return roleDto;
    }

    @Override
    public Movie movieDtoToMovie(MovieDto movieDto) {
        if (movieDto == null) {
            return null;
        }

        Movie movie = new Movie();
        return movie;
    }

    @Override
    public MovieDto movieToMovieDto(Movie movie) {
        if (movie == null) {
            return null;
        }

        MovieDto movieDto = new MovieDto();

        movieDto.setMovieId(movie.getMovieId());
        movieDto.setName(movie.getName());
        movieDto.setReleaseDate(movie.getReleaseDate());
        movieDto.setDuration(movie.getDuration());
        movieDto.setCasts(castListToCastDtoList(movie.getCasts()));
        //movieDto.setLanguages( languageListToLanguageDtoList( Movie.getLanguages() ) );
        //movieDto.setGenres( genreListToGenreDtoList( Movie.getGenres() ) );
        movieDto.setStatus(movie.getStatus());
        movieDto.setCreatedDate(movie.getCreatedDate());
        movieDto.setModifiedDate(movie.getModifiedDate());

        return movieDto;
    }

    @Override
    public Language languageDtoToLanguage(LanguageDto languageDto) {
        if (languageDto == null) {
            return null;
        }

        Language language = new Language();
        return language;
    }

    @Override
    public LanguageDto languageToLanguageDto(Language language) {
        if (language == null) {
            return null;
        }

        LanguageDto languageDto = new LanguageDto();
        return languageDto;
    }

    @Override
    public Genre genreDtoToGenre(GenreDto genreDto) {
        if (genreDto == null) {
            return null;
        }

        Genre genre = new Genre();
        return genre;
    }

    @Override
    public GenreDto genreToGenreDto(Genre genre) {
        if (genre == null) {
            return null;
        }

        GenreDto genreDto = new GenreDto();
        return genreDto;
    }

    @Override
    public Cast castDtoToCast(CastDto castDto) {
        if (castDto == null) {
            return null;
        }

        Cast cast = new Cast();
        return cast;
    }

    @Override
    public CastDto castToCastDto(Cast cast) {
        if (cast == null) {
            return null;
        }

        CastDto castDto = new CastDto();
        return castDto;
    }

    @Override
    public Booking bookingDtoToBooking(BookingDto bookingDto) {
        if (bookingDto == null) {
            return null;
        }

        Booking booking = new Booking();

        List<String> list = bookingDto.getSeatNo();
        if (list != null) {
            booking.setSeatNo(new ArrayList<String>(list));
        }
        return booking;
    }

    @Override
    public BookingDto bookingToBookingDto(Booking booking) {
        if (booking == null) {
            return null;
        }

        BookingDto bookingDto = new BookingDto();

        List<String> list = booking.getSeatNo();
        if (list != null) {
            bookingDto.setSeatNo(new ArrayList<String>(list));
        }
        return bookingDto;
    }
    public BookedSeat bookedSeatDtoToBookedSeat(BookedSeatDto bookedSeatDto) {
        if ( bookedSeatDto == null ) {
            return null;
        }

        BookedSeat bookedSeat = new BookedSeat();
        return bookedSeat;
    }

    public BookedSeatDto bookedSeatToBookedSeatDto(BookedSeat bookedSeat) {
        if ( bookedSeat == null ) {
            return null;
        }

        BookedSeatDto bookedSeatDto = new BookedSeatDto();

        return bookedSeatDto;
    }

    protected List<BookedSeat> bookedSeatDtoListToBookedSeatList(List<BookedSeatDto> list) {
        if ( list == null ) {
            return null;
        }

        List<BookedSeat> list1 = new ArrayList<BookedSeat>( list.size() );
        for ( BookedSeatDto bookedSeatDto : list ) {
            list1.add( bookedSeatDtoToBookedSeat( bookedSeatDto ) );
        }

        return list1;
    }

    protected List<BookedSeatDto> bookedSeatListToBookedSeatDtoList(List<BookedSeat> list) {
        if (list == null) {
            return null;
        }

        List<BookedSeatDto> list1 = new ArrayList<BookedSeatDto>(list.size());
        for (BookedSeat bookedSeat : list) {
            list1.add(bookedSeatToBookedSeatDto(bookedSeat));
        }

        return list1;
    }

    protected List<Seat> seatDtoListToSeatList(List<SeatDto> list) {
        if ( list == null ) {

            return null;
        }

        List<Seat> list1 = new ArrayList<Seat>(list.size());
        for (SeatDto seatDto : list) {
            list1.add(seatDtoToSeat(seatDto));
        }

        return list1;
    }

    protected List<Screening> screeningDtoListToScreeningList(List<ScreeningDto> list) {
        if ( list == null ) {

            return null;
        }

        List<Screening> list1 = new ArrayList<Screening>(list.size());
        for (ScreeningDto screeningDto : list) {
            list1.add(screeningDtoToScreening(screeningDto));
        }

        return list1;
    }

    protected List<SeatDto> seatListToSeatDtoList(List<Seat> list) {
        if ( list == null ) {

            return null;
        }

        List<SeatDto> list1 = new ArrayList<SeatDto>(list.size());
        for (Seat seat : list) {
            list1.add(seatToSeatDto(seat));
        }

        return list1;
    }
        if ( list == null ) {

            return null;
        }

        List<ScreeningDto> list1 = new ArrayList<ScreeningDto>(list.size());
        for (Screening screening : list) {
            list1.add(screeningToScreeningDto(screening));
        }

        return list1;
    }

    protected List<Booking> bookingDtoListToBookingList(List<BookingDto> list) {
        if ( list == null ) {

            return null;
        }

        List<Booking> list1 = new ArrayList<Booking>(list.size());
        for (BookingDto bookingDto : list) {
            list1.add(bookingDtoToBooking(bookingDto));
        }

        return list1;
    }

    protected List<BookingDto> bookingListToBookingDtoList(List<Booking> list) {
        if ( list == null ) {

            return null;
        }

        List<BookingDto> list1 = new ArrayList<BookingDto>(list.size());
        for (Booking booking : list) {
            list1.add(bookingToBookingDto(booking));
        }

        return list1;
    }

    protected List<Users> usersDtoListToUsersList(List<UsersDto> list) {
        if ( list == null ) {

            return null;
        }

        List<Users> list1 = new ArrayList<Users>(list.size());
        for (UsersDto usersDto : list) {
            list1.add(usersDtoToUsers(usersDto));
        }

        return list1;
    }

    protected List<UsersDto> usersListToUsersDtoList(List<Users> list) {
        if ( list == null ) {

            return null;
        }

        List<UsersDto> list1 = new ArrayList<UsersDto>(list.size());
        for (Users users : list) {
            list1.add(usersToUsersDto(users));
        }

        return list1;
    }

    protected List<Cast> castDtoListToCastList(List<CastDto> list) {
        if ( list == null ) {

            return null;
        }

        List<Cast> list1 = new ArrayList<Cast>(list.size());
        for (CastDto castDto : list) {
            list1.add(castDtoToCast(castDto));
        }

        return list1;
    }

    protected List<Language> languageDtoListToLanguageList(List<LanguageDto> list) {
        if ( list == null ) {

            return null;
        }

        List<Language> list1 = new ArrayList<Language>(list.size());
        for (LanguageDto languageDto : list) {
            list1.add(languageDtoToLanguage(languageDto));
        }

        return list1;
    }

    protected List<Genre> genreDtoListToGenreList(List<GenreDto> list) {
        if ( list == null ) {

            return null;
        }

        List<Genre> list1 = new ArrayList<Genre>(list.size());
        for (GenreDto genreDto : list) {
            list1.add(genreDtoToGenre(genreDto));
        }

        return list1;
    }

        if ( list == null ) {

            return null;
        }

        List<CastDto> list1 = new ArrayList<CastDto>(list.size());
        for (Cast cast : list) {
            list1.add(castToCastDto(cast));
        }

        return list1;
    }

    protected List<LanguageDto> languageListToLanguageDtoList(List<Language> list) {
        if ( list == null ) {

            return null;
        }

        List<LanguageDto> list1 = new ArrayList<LanguageDto>(list.size());
        for (Language language : list) {
            list1.add(languageToLanguageDto(language));
        }

        return list1;
    }

        if ( list == null ) {

            return null;
        }

        List<GenreDto> list1 = new ArrayList<GenreDto>(list.size());
        for (Genre genre : list) {
            list1.add(genreToGenreDto(genre));
        }

        return list1;
    }

    protected List<Movie> movieDtoListToMovieList(List<MovieDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Movie> list1 = new ArrayList<Movie>(list.size());
        for (MovieDto movieDto : list) {
            list1.add(movieDtoToMovie(movieDto));
        }

        return list1;
    }
        if ( list == null ) {
            return null;
        }

        List<MovieDto> list1 = new ArrayList<MovieDto>(list.size());
        for (Movie movie : list) {
            list1.add(movieToMovieDto(movie));
        }

        return list1;
    }
}
