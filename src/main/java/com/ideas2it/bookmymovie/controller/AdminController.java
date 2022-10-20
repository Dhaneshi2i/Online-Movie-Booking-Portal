package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.MovieDto;
import com.ideas2it.bookmymovie.dto.ScreenDto;
import com.ideas2it.bookmymovie.dto.SeatDto;
import com.ideas2it.bookmymovie.dto.ShowDto;
import com.ideas2it.bookmymovie.dto.TheatreDto;
import com.ideas2it.bookmymovie.dto.responseDto.ShowSlimDto;
import com.ideas2it.bookmymovie.service.MovieService;
import com.ideas2it.bookmymovie.service.ScreenService;
import com.ideas2it.bookmymovie.service.SeatService;
import com.ideas2it.bookmymovie.service.ShowService;
import com.ideas2it.bookmymovie.service.TheatreService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 * AdminController class  will create the new cast, language,
 *
 *
 * </p>
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 **/
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

//    private final GenreService genreService;
//    private final CastService castService;
//    private final LanguageService languageService;
//    private final RoleService roleService;

    private final TheatreService theatreService;
    private final MovieService movieService;
    private final ScreenService screenService;
    private final ShowService showService;
    private final SeatService seatService;

    public AdminController(TheatreService theatreService, MovieService movieService, ScreenService screenService,
                           ShowService showService, SeatService seatService) {
        this.theatreService = theatreService;
        this.movieService = movieService;
        this.screenService = screenService;
        this.showService = showService;
    }

    /*@PostMapping("/role")
    public RoleDto createRole(@Valid @RequestBody RoleDto roleDto) {
        return roleService.addRole(roleDto);
    }
    @PostMapping("/cast")
    public CastDto createCast(@Valid @RequestBody CastDto castDto) {
        return castService.addCast(castDto);
    }

    @PostMapping("/language")
    public LanguageDto createLanguage(@Valid @RequestBody LanguageDto languageDto) {
        return languageService.addLanguage(languageDto);
    }

    @PostMapping("/genre")
    public GenreDto createGenre(@Valid @RequestBody GenreDto genreDto) {
        return genreService.addGenre(genreDto);
    }*/

    @PostMapping("/theatre")
    public TheatreDto createTheatre(@Valid @RequestBody TheatreDto theatreDto) {
        return theatreService.createTheatre(theatreDto);
    }

    @PostMapping("/movie")
    public MovieDto createMovie(@Valid @RequestBody MovieDto movieDto) {
        return movieService.addMovie(movieDto);
    }

    /**
     *
     * @param screenDto
     * @param theatreId
     * @return addedScreen
     * @throws com.ideas2it.bookmymovie.exception.NotFoundException
     */
    @PostMapping("/screen")
    public ScreenDto createScreen(@Valid @RequestBody ScreenDto screenDto, @RequestParam int theatreId) {
        return screenService.createScreen(screenDto, theatreId);
    }

    /**
     * Stores a Show object in the Database.
     *
     * @param showDto
     * @param theatreId
     * @param screenId
     * @return Show

     */
    @PostMapping("/show")
    public ShowSlimDto createShow(@Valid @RequestBody ShowDto showDto,
                                      @RequestParam int theatreId, @RequestParam int screenId) {
        return showService.createShow(showDto, theatreId, screenId);
    }

    @PostMapping("/seat")
    public SeatDto addSeat(@Valid @RequestBody SeatDto seatDto) {
        return seatService.createSeat(seatDto);
    }



}









    /*@GetMapping("/cast/{id}")
    public CastDto getCast(@PathVariable String name) throws NotFoundException {
        return castService.getCastByName(name);
    }*/

/*    @GetMapping("/language/{name}")
    public LanguageDto getLanguage(@PathVariable String name) {
        return languageService.getLanguageByName(name);
    }

    @GetMapping("/genre/{name}")
    public GenreDto getGenre(@PathVariable String name) {
        return genreService.getGenreByName(name);
    }*/