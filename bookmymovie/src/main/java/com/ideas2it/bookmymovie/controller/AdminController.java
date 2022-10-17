package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.CastDto;
import com.ideas2it.bookmymovie.dto.GenreDto;
import com.ideas2it.bookmymovie.dto.LanguageDto;
import com.ideas2it.bookmymovie.dto.MovieDto;
import com.ideas2it.bookmymovie.dto.RoleDto;
import com.ideas2it.bookmymovie.dto.ScreenDto;
import com.ideas2it.bookmymovie.dto.ScreeningDto;
import com.ideas2it.bookmymovie.dto.SeatDto;
import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.service.CastService;
import com.ideas2it.bookmymovie.service.GenreService;
import com.ideas2it.bookmymovie.service.LanguageService;
import com.ideas2it.bookmymovie.service.MovieService;
import com.ideas2it.bookmymovie.service.RoleService;
import com.ideas2it.bookmymovie.service.ScreenService;
import com.ideas2it.bookmymovie.service.ScreeningService;
import com.ideas2it.bookmymovie.service.SeatService;
import com.ideas2it.bookmymovie.service.TheatreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/i2i/V1/admin")
public class AdminController {
    public GenreService genreService;
    public CastService castService;
    public LanguageService languageService;
    public RoleService roleService;
    public ScreeningService screeningService;
    public ScreenService screenService;
    public SeatService seatService;
    public TheatreService theatreService;
    public MovieService movieService;

    public AdminController(GenreService genreService, CastService castService, LanguageService languageService,
                           RoleService roleService, ScreeningService screeningService, ScreenService screenService,
                           SeatService seatService, TheatreService theatreService, MovieService movieService) {
        this.genreService = genreService;
        this.castService = castService;
        this.languageService = languageService;
        this.roleService = roleService;
        this.screeningService = screeningService;
        this.screenService = screenService;
        this.seatService = seatService;
        this.theatreService = theatreService;
        this.movieService = movieService;
    }

    @PostMapping("/addCast")
    public ResponseEntity<CastDto> addCast(@RequestBody CastDto castDto) {
        return new ResponseEntity<>(castService.addCast(castDto), HttpStatus.OK);
    }

    /*@GetMapping("/getCast/{name}")
    public ResponseEntity<CastDto> getCast(@PathVariable String name) throws NotFoundException {
        return new ResponseEntity<>(castService.getCastByName(name), HttpStatus.OK);
    }*/

    @PostMapping("/addLanguage")
    public ResponseEntity<LanguageDto> addLanguage(@RequestBody LanguageDto languageDto) {
        return new ResponseEntity<>(languageService.addLanguage(languageDto), HttpStatus.OK);
    }

    @PostMapping("/addGenre")
    public ResponseEntity<GenreDto> addGenre(@RequestBody GenreDto genreDto) {
        return new ResponseEntity<>(genreService.addGenre(genreDto), HttpStatus.OK);
    }

    @PostMapping("/addScreen")
    public ResponseEntity<ScreenDto> addScreen(@RequestBody ScreenDto screenDto) {
        return new ResponseEntity<>(screenService.createScreenDetails(screenDto), HttpStatus.OK);
    }

    @PostMapping("/addScreening")
    public ResponseEntity<ScreeningDto>  addScreening(@RequestBody ScreeningDto screeningDto) {
        return new ResponseEntity<>(screeningService.addScreening(screeningDto), HttpStatus.OK);
    }

    @PostMapping("/addRole")
    public ResponseEntity<RoleDto> createRoles(@RequestBody RoleDto roleDto) {
        return new ResponseEntity<>(roleService.saveRole(roleDto), HttpStatus.OK);
    }

    /*@GetMapping("/getRoleById")
    public ResponseEntity<SeatDto> getSeatById(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(seatService.getSeatById(id), HttpStatus.OK);
    }*/
    // Seat operations
    @PostMapping("/addSeat")
    public ResponseEntity<SeatDto> createSeat(@RequestBody SeatDto seatDto) {
        return new ResponseEntity<>(seatService.createSeat(seatDto), HttpStatus.OK);
    }

    @GetMapping("/getAllSeats")
    public ResponseEntity<List<SeatDto>> getAllSeats() throws NotFoundException {
        return new ResponseEntity<>(seatService.getAllSeats(), HttpStatus.OK);
    }

    @GetMapping("/getSeat/{id}")
    public ResponseEntity<SeatDto> getSeatById(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(seatService.getSeatById(id), HttpStatus.OK);
    }

    /*@PatchMapping("/updateSeat")
    public ResponseEntity<SeatDto> updateSeat (@PathVariable int id) throws NotFoundException {
        SeatDto seatDto = seatService.getSeatById(id);
        return new ResponseEntity<>(seatService.cancelSeat(seatDto), HttpStatus.OK);
    }*/

    // Theatre operations for admin
    @PostMapping("/addTheatre")
    public ResponseEntity<TheatreDto> addTheatre(@RequestBody TheatreDto theatreDto) {
        return new ResponseEntity<>(theatreService.createTheatreDetails(theatreDto), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<TheatreDto>> getAllTheatre() throws NotFoundException {
        return new ResponseEntity<>(theatreService.listAllTheatre(), HttpStatus.OK);
    }

    @GetMapping("/screen/get")
    public ResponseEntity<List<ScreenDto>> getAllScreen() throws NotFoundException {
        return new ResponseEntity<>(screenService.listAllScreen(), HttpStatus.OK);
    }

    @GetMapping("/{cityName}")
    public ResponseEntity<List<TheatreDto>> getTheatreByCityName(@PathVariable("cityName") String cityName)
            throws NotFoundException {
        return new ResponseEntity<>(theatreService.ListTheatreByCityName(cityName), HttpStatus.OK);
    }

    // Movie operations by admin

    @PostMapping("/addMovie")
    public ResponseEntity<MovieDto> addMovie(@RequestBody MovieDto  movieDto) {
        return new ResponseEntity<>(movieService.addMovie(movieDto), HttpStatus.OK);
    }

    @GetMapping("/getMovies")
    public ResponseEntity<List<MovieDto>> getMovies() throws NotFoundException {

        return new ResponseEntity<>(movieService.getMovies(), HttpStatus.OK);
    }

    @GetMapping("genre/{genre}")
    public ResponseEntity<List<MovieDto>> getMovieByGenre(@PathVariable("genre") String genre) throws NotFoundException {

        return new ResponseEntity<>(movieService.getMovieByGenre(genre), HttpStatus.OK);
    }

    @GetMapping("language/{language}")
    public ResponseEntity<List<MovieDto>> getMovieByLanguage(@PathVariable("language") String language) throws NotFoundException {

        return new ResponseEntity<List<MovieDto>>(movieService.getMovieByLanguage(language), HttpStatus.OK);
    }
}
