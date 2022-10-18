package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.RoleDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/V1/admin")
public class AdminController {
    private final GenreService genreService;
    private final CastService castService;
    private final LanguageService languageService;
    private final RoleService roleService;
    private final ScreeningService screeningService;
    private final ScreenService screenService;
    private final SeatService seatService;
    private final TheatreService theatreService;
    private final MovieService movieService;

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

    @GetMapping("/getCast/{name}")
    public ResponseEntity<CastDto> getCast(@PathVariable String name) throws NotFoundException {
        return new ResponseEntity<>(castService.getCastByName(name), HttpStatus.OK);
    }

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

    @PatchMapping("/updateSeat")
    public ResponseEntity<SeatDto> updateSeat (@PathVariable int id) throws NotFoundException {
        SeatDto seatDto = seatService.getSeatById(id);
        return new ResponseEntity<>(seatService.cancelSeat(seatDto), HttpStatus.OK);
    }

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

    @PatchMapping("/updateTheatre/{theatreId}/{status}")
    public ResponseEntity<TheatreDto> updateTheatreStatus(@PathVariable("theatreId") int theatreId, @PathVariable
            ("status") Boolean status) throws NotFoundException {
        return new ResponseEntity<>(theatreService.updateTheatreStatusDetail(theatreId, status), HttpStatus.OK);
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
