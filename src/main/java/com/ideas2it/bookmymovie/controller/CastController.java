package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.CastDto;
import com.ideas2it.bookmymovie.service.CastService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cast")
public class CastController {
    private final CastService castService;

    public CastController(CastService castService) {
        this.castService = castService;
    }

    /**
     * <p>
     * This method is used to create Cast Details
     * </p>
     *
     * @param castDto it contains cast dto objects
     * @return CastResponseDto
     */
    @PostMapping
    public CastDto createCast(@Valid @RequestBody CastDto castDto) {
        return castService.addCast(castDto);
    }

    @GetMapping
    public List<CastDto> getAllCast() {
        return castService.getAllCasts();
    }
}
