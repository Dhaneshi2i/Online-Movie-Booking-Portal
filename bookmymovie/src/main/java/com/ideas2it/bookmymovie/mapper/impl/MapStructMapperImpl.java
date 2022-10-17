package com.ideas2it.bookmymovie.mapper.impl;

import com.ideas2it.bookmymovie.dto.BookedSeatDto;
import com.ideas2it.bookmymovie.dto.BookingDto;
import com.ideas2it.bookmymovie.dto.CastDto;
import com.ideas2it.bookmymovie.dto.GenreDto;
import com.ideas2it.bookmymovie.dto.LanguageDto;
import com.ideas2it.bookmymovie.dto.MovieDto;
import com.ideas2it.bookmymovie.dto.RoleDto;
import com.ideas2it.bookmymovie.dto.ScreenDto;
import com.ideas2it.bookmymovie.dto.ScreeningDto;
import com.ideas2it.bookmymovie.dto.SeatDto;
import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.dto.UsersDto;
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
        date = "2022-10-16T23:35:18+0530",
        comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class MapStructMapperImpl implements MapStructMapper {

    @Override
    public Users usersDtoToUsers(UsersDto usersDto) {
        if ( usersDto == null ) {
            return null;
        }

        Users users = new Users();

        users.setUserId( usersDto.getUserId() );
        users.setName( usersDto.getName() );
        users.setEmailId( usersDto.getEmailId() );
        users.setContactNumber( usersDto.getContactNumber() );
        users.setPassword( usersDto.getPassword() );
        users.setCreationDate( usersDto.getCreationDate() );
        users.setModifiedDate( usersDto.getModifiedDate() );
        users.setStatus( usersDto.isStatus() );
        users.setRole( roleDtoToRole( usersDto.getRole() ) );

        return users;
    }

    @Override
    public UsersDto usersToUsersDto(Users users) {
        if ( users == null ) {
            return null;
        }

        UsersDto usersDto = new UsersDto();

        usersDto.setUserId( users.getUserId() );
        usersDto.setName( users.getName() );
        usersDto.setEmailId( users.getEmailId() );
        usersDto.setContactNumber( users.getContactNumber() );
        usersDto.setPassword( users.getPassword() );
        usersDto.setRole( roleToRoleDto( users.getRole() ) );
        usersDto.setCreationDate( users.getCreationDate() );
        usersDto.setModifiedDate( users.getModifiedDate() );
        usersDto.setStatus( users.isStatus() );

        return usersDto;
    }

    @Override
    public Theatre theatreDtoToTheatre(TheatreDto theatreDto) {
        if ( theatreDto == null ) {
            return null;
        }

        Theatre theatre = new Theatre();

        theatre.setTheatreId( theatreDto.getTheatreId() );
        theatre.setName( theatreDto.getName() );
        theatre.setCityName( theatreDto.getCityName() );
        List<Screen> screens = new ArrayList<>();
        List<ScreenDto> screenDtos = theatreDto.getScreensDto();
        for(ScreenDto screenDto : screenDtos){
            Screen screen = new Screen();
            if(screenDto != null){
                if (screenDto.getScreenId() != 0) {
                    screen.setScreenId(screenDto.getScreenId());
                }
                screen.setNoOfSeats(screenDto.getNoOfSeats());
                screen.setNoOfRows(screenDto.getNoOfRows());
                screen.setNoOfColumns(screenDto.getNoOfColumns());
                screens.add(screen);
            }
            theatre.setScreens(screens);
        }

        return theatre;
    }

    @Override
    public TheatreDto theatreToTheatreDto(Theatre theatre) {
        if ( theatre == null ) {
            return null;
        }

        TheatreDto theatreDto = new TheatreDto();

        theatreDto.setTheatreId( theatre.getTheatreId() );
        theatreDto.setName( theatre.getName() );
        theatreDto.setCityName( theatre.getCityName() );
        List<Screen> screens = theatre.getScreens();
        List<ScreenDto> screenDtos = new ArrayList<>();
        for(Screen screen : screens){
          ScreenDto screenDto = new ScreenDto();
          if(screen != null){
              if (screen.getScreenId() != 0) {
                  screenDto.setScreenId(screen.getScreenId());
              }
              screenDto.setNoOfSeats(screen.getNoOfSeats());
              screenDto.setNoOfRows(screen.getNoOfRows());
              screenDto.setNoOfColumns(screen.getNoOfColumns());
              screenDtos.add(screenDto);
          }
          theatreDto.setScreensDto(screenDtos);
        }
        return theatreDto;
    }

    @Override
    public Seat seatDtoToSeat(SeatDto seatDto) {
        if ( seatDto == null ) {
            return null;
        }

        Seat seat = new Seat();

        seat.setSeatId( seatDto.getSeatId() );
        seat.setSeatNo( seatDto.getSeatNo() );
        seat.setScreen( screenDtoToScreen( seatDto.getScreen() ) );
        seat.setBookedSeats( bookedSeatDtoListToBookedSeatList( seatDto.getBookedSeats() ) );

        return seat;
    }

    @Override
    public SeatDto seatToSeatDto(Seat seat) {
        if ( seat == null ) {
            return null;
        }

        SeatDto seatDto = new SeatDto();

        seatDto.setSeatId( seat.getSeatId() );
        seatDto.setSeatNo( seat.getSeatNo() );
        seatDto.setScreen( screenToScreenDto( seat.getScreen() ) );
        seatDto.setBookedSeats( bookedSeatListToBookedSeatDtoList( seat.getBookedSeats() ) );

        return seatDto;
    }

    @Override
    public Screen screenDtoToScreen(ScreenDto screenDto) {
        if ( screenDto == null ) {
            return null;
        }
        Screen screen = new Screen();
        screen.setScreenId( screenDto.getScreenId() );
        screen.setNoOfSeats( screenDto.getNoOfSeats() );
        screen.setNoOfRows( screenDto.getNoOfRows() );
        screen.setNoOfColumns( screenDto.getNoOfColumns() );
        TheatreDto theatreDto = screenDto.getTheatreDto();
        if(theatreDto !=null){
            Theatre theatre = new Theatre();
            if(theatreDto.getTheatreId() != 0){
                theatre.setTheatreId(theatreDto.getTheatreId());
            }
            theatre.setName(theatreDto.getName());
            theatre.setCityName(theatreDto.getCityName());
            screen.setTheatre(theatre);
        }
        //screen.setSeats( seatDtoListToSeatList( screenDto.getSeats() ) );
        //screen.setScreenings( screeningDtoListToScreeningList( screenDto.getScreenings() ) );
        return screen;
    }

    @Override
    public ScreenDto screenToScreenDto(Screen screen) {
        if ( screen == null ) {
            return null;
        }
        ScreenDto screenDto = new ScreenDto();

        screenDto.setScreenId( screen.getScreenId() );
        screenDto.setNoOfSeats( screen.getNoOfSeats() );
        screenDto.setNoOfRows( screen.getNoOfRows() );
        screenDto.setNoOfColumns( screen.getNoOfColumns() );
        Theatre theatre = screen.getTheatre();
        if(theatre !=null){
            TheatreDto theatreDto = new TheatreDto();
            if(theatre.getTheatreId() != 0){
                theatreDto.setTheatreId(theatre.getTheatreId());
            }
            theatreDto.setName(theatre.getName());
            theatreDto.setCityName(theatre.getCityName());
            screenDto.setTheatreDto(theatreDto);
        }
        //screenDto.setSeats( seatListToSeatDtoList( screen.getSeats() ) );
        //screenDto.setScreenings( screeningListToScreeningDtoList( screen.getScreenings() ) );
        return screenDto;
    }

    @Override
    public Screening screeningDtoToScreening(ScreeningDto screeningDto) {
        if ( screeningDto == null ) {
            return null;
        }

        Screening screening = new Screening();

        screening.setScreeningId( screeningDto.getScreeningId() );
        screening.setMovie( movieDtoToMovie( screeningDto.getMovie() ) );
        screening.setShowDate( screeningDto.getShowDate() );
        screening.setStartTime( screeningDto.getStartTime() );
        screening.setBookedSeats( bookedSeatDtoListToBookedSeatList( screeningDto.getBookedSeats() ) );
        screening.setBookings( bookingDtoListToBookingList( screeningDto.getBookings() ) );
        screening.setScreen( screenDtoToScreen( screeningDto.getScreen() ) );

        return screening;
    }

    @Override
    public ScreeningDto screeningToScreeningDto(Screening screening) {
        if ( screening == null ) {
            return null;
        }

        ScreeningDto screeningDto = new ScreeningDto();

        screeningDto.setScreeningId( screening.getScreeningId() );
        screeningDto.setMovie( movieToMovieDto( screening.getMovie() ) );
        screeningDto.setShowDate( screening.getShowDate() );
        screeningDto.setStartTime( screening.getStartTime() );
        screeningDto.setBookedSeats( bookedSeatListToBookedSeatDtoList( screening.getBookedSeats() ) );
        screeningDto.setBookings( bookingListToBookingDtoList( screening.getBookings() ) );
        screeningDto.setScreen( screenToScreenDto( screening.getScreen() ) );

        return screeningDto;
    }

    @Override
    public Role roleDtoToRole(RoleDto roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setRoleId( roleDto.getRoleId() );
        role.setRoleType( roleDto.getRoleType() );
        role.setUsers( usersDtoListToUsersList( roleDto.getUsers() ) );

        return role;
    }

    @Override
    public RoleDto roleToRoleDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        roleDto.setRoleId( role.getRoleId() );
        roleDto.setRoleType( role.getRoleType() );
        roleDto.setUsers( usersListToUsersDtoList( role.getUsers() ) );

        return roleDto;
    }

    @Override
    public Movie movieDtoToMovie(MovieDto movieDto) {
        if ( movieDto == null ) {
            return null;
        }

        Movie movie = new Movie();

        movie.setMovieId( movieDto.getMovieId() );
        movie.setName( movieDto.getName() );
        movie.setReleaseDate( movieDto.getReleaseDate() );
        movie.setDuration( movieDto.getDuration() );
        movie.setCasts( castDtoListToCastList( movieDto.getCasts() ) );
        movie.setLanguages( languageDtoListToLanguageList( movieDto.getLanguages() ) );
        movie.setGenres( genreDtoListToGenreList( movieDto.getGenres() ) );
        movie.setStatus( movieDto.getStatus() );
        movie.setCreatedDate( movieDto.getCreatedDate() );
        movie.setModifiedDate( movieDto.getModifiedDate() );

        return movie;
    }

    @Override
    public MovieDto movieToMovieDto(Movie Movie) {
        if ( Movie == null ) {
            return null;
        }

        MovieDto movieDto = new MovieDto();

        movieDto.setMovieId( Movie.getMovieId() );
        movieDto.setName( Movie.getName() );
        movieDto.setReleaseDate( Movie.getReleaseDate() );
        movieDto.setDuration( Movie.getDuration() );
        movieDto.setCasts( castListToCastDtoList( Movie.getCasts() ) );
        movieDto.setLanguages( languageListToLanguageDtoList( Movie.getLanguages() ) );
        movieDto.setGenres( genreListToGenreDtoList( Movie.getGenres() ) );
        movieDto.setStatus( Movie.getStatus() );
        movieDto.setCreatedDate( Movie.getCreatedDate() );
        movieDto.setModifiedDate( Movie.getModifiedDate() );

        return movieDto;
    }

    @Override
    public Language languageDtoToLanguage(LanguageDto languageDto) {
        if ( languageDto == null ) {
            return null;
        }

        Language language = new Language();

        language.setName( languageDto.getName() );
        language.setMovies( movieDtoListToMovieList( languageDto.getMovies() ) );

        return language;
    }

    @Override
    public LanguageDto languageToLanguageDto(Language language) {
        if ( language == null ) {
            return null;
        }

        LanguageDto languageDto = new LanguageDto();

        languageDto.setName( language.getName() );
        languageDto.setMovies( movieListToMovieDtoList( language.getMovies() ) );

        return languageDto;
    }

    @Override
    public Genre genreDtoToGenre(GenreDto genreDto) {
        if ( genreDto == null ) {
            return null;
        }

        Genre genre = new Genre();

        genre.setName( genreDto.getName() );
        genre.setMovies( movieDtoListToMovieList( genreDto.getMovies() ) );

        return genre;
    }

    @Override
    public GenreDto genreToGenreDto(Genre genre) {
        if ( genre == null ) {
            return null;
        }

        GenreDto genreDto = new GenreDto();

        genreDto.setName( genre.getName() );
        genreDto.setMovies( movieListToMovieDtoList( genre.getMovies() ) );

        return genreDto;
    }

    @Override
    public Cast castDtoToCast(CastDto castDto) {
        if ( castDto == null ) {
            return null;
        }

        Cast cast = new Cast();

        cast.setName( castDto.getName() );
        cast.setRole( castDto.getRole() );
        cast.setMovies( movieDtoListToMovieList( castDto.getMovies() ) );

        return cast;
    }

    @Override
    public CastDto castToCastDto(Cast cast) {
        if ( cast == null ) {
            return null;
        }

        CastDto castDto = new CastDto();

        castDto.setName( cast.getName() );
        castDto.setRole( cast.getRole() );
        castDto.setMovies( movieListToMovieDtoList( cast.getMovies() ) );

        return castDto;
    }

    @Override
    public Booking bookingDtoToBooking(BookingDto bookingDto) {
        if ( bookingDto == null ) {
            return null;
        }

        Booking booking = new Booking();

        List<String> list = bookingDto.getSeatNo();
        if ( list != null ) {
            booking.setSeatNo( new ArrayList<String>( list ) );
        }
        booking.setBookingDate( bookingDto.getBooking_date() );
        booking.setBookedSeats( bookedSeatDtoListToBookedSeatList( bookingDto.getBookedSeats() ) );
        booking.setCreationDate( bookingDto.getCreationDate() );
        booking.setModifiedDate( bookingDto.getModifiedDate() );
        booking.setStatus( bookingDto.isStatus() );

        return booking;
    }

    @Override
    public BookingDto bookingToBookingDto(Booking booking) {
        if ( booking == null ) {
            return null;
        }

        BookingDto bookingDto = new BookingDto();

        List<String> list = booking.getSeatNo();
        if ( list != null ) {
            bookingDto.setSeatNo( new ArrayList<String>( list ) );
        }
        bookingDto.setBooking_date( booking.getBookingDate() );
        bookingDto.setBookedSeats( bookedSeatListToBookedSeatDtoList( booking.getBookedSeats() ) );
        bookingDto.setCreationDate( booking.getCreationDate() );
        bookingDto.setModifiedDate( booking.getModifiedDate() );
        bookingDto.setStatus( booking.isStatus() );

        return bookingDto;
    }

    protected List<Screen> screenDtoListToScreenList(List<ScreenDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Screen> list1 = new ArrayList<Screen>( list.size() );
        for ( ScreenDto screenDto : list ) {
            list1.add( screenDtoToScreen( screenDto ) );
        }

        return list1;
    }

    protected List<ScreenDto> screenListToScreenDtoList(List<Screen> list) {
        if ( list == null ) {
            return null;
        }

        List<ScreenDto> list1 = new ArrayList<ScreenDto>( list.size() );
        for ( Screen screen : list ) {
            list1.add( screenToScreenDto( screen ) );
        }

        return list1;
    }

    protected BookedSeat bookedSeatDtoToBookedSeat(BookedSeatDto bookedSeatDto) {
        if ( bookedSeatDto == null ) {
            return null;
        }

        BookedSeat bookedSeat = new BookedSeat();

        bookedSeat.setBookedSeatId( bookedSeatDto.getBookedSeatId() );
        bookedSeat.setSeat( seatDtoToSeat( bookedSeatDto.getSeat() ) );
        bookedSeat.setBooking( bookingDtoToBooking( bookedSeatDto.getBooking() ) );
        bookedSeat.setScreening( screeningDtoToScreening( bookedSeatDto.getScreening() ) );

        return bookedSeat;
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

    protected BookedSeatDto bookedSeatToBookedSeatDto(BookedSeat bookedSeat) {
        if ( bookedSeat == null ) {
            return null;
        }

        BookedSeatDto bookedSeatDto = new BookedSeatDto();

        if ( bookedSeat.getBookedSeatId() != 0 ) {
            bookedSeatDto.setBookedSeatId( bookedSeat.getBookedSeatId() );
        }
        bookedSeatDto.setSeat( seatToSeatDto( bookedSeat.getSeat() ) );
        bookedSeatDto.setBooking( bookingToBookingDto( bookedSeat.getBooking() ) );
        bookedSeatDto.setScreening( screeningToScreeningDto( bookedSeat.getScreening() ) );

        return bookedSeatDto;
    }

    protected List<BookedSeatDto> bookedSeatListToBookedSeatDtoList(List<BookedSeat> list) {
        if ( list == null ) {
            return null;
        }

        List<BookedSeatDto> list1 = new ArrayList<BookedSeatDto>( list.size() );
        for ( BookedSeat bookedSeat : list ) {
            list1.add( bookedSeatToBookedSeatDto( bookedSeat ) );
        }

        return list1;
    }

    protected List<Seat> seatDtoListToSeatList(List<SeatDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Seat> list1 = new ArrayList<Seat>( list.size() );
        for ( SeatDto seatDto : list ) {
            list1.add( seatDtoToSeat( seatDto ) );
        }

        return list1;
    }

    protected List<Screening> screeningDtoListToScreeningList(List<ScreeningDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Screening> list1 = new ArrayList<Screening>( list.size() );
        for ( ScreeningDto screeningDto : list ) {
            list1.add( screeningDtoToScreening( screeningDto ) );
        }

        return list1;
    }

    protected List<SeatDto> seatListToSeatDtoList(List<Seat> list) {
        if ( list == null ) {
            return null;
        }

        List<SeatDto> list1 = new ArrayList<SeatDto>( list.size() );
        for ( Seat seat : list ) {
            list1.add( seatToSeatDto( seat ) );
        }

        return list1;
    }

    protected List<ScreeningDto> screeningListToScreeningDtoList(List<Screening> list) {
        if ( list == null ) {
            return null;
        }

        List<ScreeningDto> list1 = new ArrayList<ScreeningDto>( list.size() );
        for ( Screening screening : list ) {
            list1.add( screeningToScreeningDto( screening ) );
        }

        return list1;
    }

    protected List<Booking> bookingDtoListToBookingList(List<BookingDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Booking> list1 = new ArrayList<Booking>( list.size() );
        for ( BookingDto bookingDto : list ) {
            list1.add( bookingDtoToBooking( bookingDto ) );
        }

        return list1;
    }

    protected List<BookingDto> bookingListToBookingDtoList(List<Booking> list) {
        if ( list == null ) {
            return null;
        }

        List<BookingDto> list1 = new ArrayList<BookingDto>( list.size() );
        for ( Booking booking : list ) {
            list1.add( bookingToBookingDto( booking ) );
        }

        return list1;
    }

    protected List<Users> usersDtoListToUsersList(List<UsersDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Users> list1 = new ArrayList<Users>( list.size() );
        for ( UsersDto usersDto : list ) {
            list1.add( usersDtoToUsers( usersDto ) );
        }

        return list1;
    }

    protected List<UsersDto> usersListToUsersDtoList(List<Users> list) {
        if ( list == null ) {
            return null;
        }

        List<UsersDto> list1 = new ArrayList<UsersDto>( list.size() );
        for ( Users users : list ) {
            list1.add( usersToUsersDto( users ) );
        }

        return list1;
    }

    protected List<Cast> castDtoListToCastList(List<CastDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Cast> list1 = new ArrayList<Cast>( list.size() );
        for ( CastDto castDto : list ) {
            list1.add( castDtoToCast( castDto ) );
        }

        return list1;
    }

    protected List<Language> languageDtoListToLanguageList(List<LanguageDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Language> list1 = new ArrayList<Language>( list.size() );
        for ( LanguageDto languageDto : list ) {
            list1.add( languageDtoToLanguage( languageDto ) );
        }

        return list1;
    }

    protected List<Genre> genreDtoListToGenreList(List<GenreDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Genre> list1 = new ArrayList<Genre>( list.size() );
        for ( GenreDto genreDto : list ) {
            list1.add( genreDtoToGenre( genreDto ) );
        }

        return list1;
    }

    protected List<CastDto> castListToCastDtoList(List<Cast> list) {
        if ( list == null ) {
            return null;
        }

        List<CastDto> list1 = new ArrayList<CastDto>( list.size() );
        for ( Cast cast : list ) {
            list1.add( castToCastDto( cast ) );
        }

        return list1;
    }

    protected List<LanguageDto> languageListToLanguageDtoList(List<Language> list) {
        if ( list == null ) {
            return null;
        }

        List<LanguageDto> list1 = new ArrayList<LanguageDto>( list.size() );
        for ( Language language : list ) {
            list1.add( languageToLanguageDto( language ) );
        }

        return list1;
    }

    protected List<GenreDto> genreListToGenreDtoList(List<Genre> list) {
        if ( list == null ) {
            return null;
        }

        List<GenreDto> list1 = new ArrayList<GenreDto>( list.size() );
        for ( Genre genre : list ) {
            list1.add( genreToGenreDto( genre ) );
        }

        return list1;
    }

    protected List<Movie> movieDtoListToMovieList(List<MovieDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Movie> list1 = new ArrayList<Movie>( list.size() );
        for ( MovieDto movieDto : list ) {
            list1.add( movieDtoToMovie( movieDto ) );
        }

        return list1;
    }

    protected List<MovieDto> movieListToMovieDtoList(List<Movie> list) {
        if ( list == null ) {
            return null;
        }

        List<MovieDto> list1 = new ArrayList<MovieDto>( list.size() );
        for ( Movie movie : list ) {
            list1.add( movieToMovieDto( movie ) );
        }

        return list1;
    }
}
