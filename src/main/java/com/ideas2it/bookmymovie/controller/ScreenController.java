package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.ScreenDto;
import com.ideas2it.bookmymovie.dto.responseDto.ScreenSlimDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.service.ScreenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/screen")
public class ScreenController {

    private ScreenService screenService;

    public ScreenController(ScreenService screenService) {
        this.screenService = screenService;
    }


    /**
     * @param screenDto
     * @param theatreId
     * @return addedScreen
     * @throws NotFoundException
     */
    @PostMapping
    public ScreenDto createScreen(@Valid @RequestBody ScreenDto screenDto, @RequestParam int theatreId) {
        return screenService.createScreen(screenDto, theatreId);
    }

    /**
     * @return screenList
     * @throws NotFoundException
     */
    @GetMapping
    public List<ScreenDto> viewScreenList() throws NotFoundException {
        return screenService.getAllScreen();

    }

    @GetMapping("/{screenId}")
    public ScreenSlimDto viewScreen(@PathVariable int screenId) throws NotFoundException {
        ScreenSlimDto screenDto = screenService.getScreenById(screenId);
        //log.info("-------Screen Found---------");
        return screenDto;
    }

    /**
     * @param screenId
     * @throws NotFoundException
     */
    @PatchMapping
    public ScreenDto updateScreen(@RequestParam Integer screenId) throws NotFoundException {
        ScreenDto screenDto = screenService.updateScreenById(screenId);
        return screenDto;
    }
}
