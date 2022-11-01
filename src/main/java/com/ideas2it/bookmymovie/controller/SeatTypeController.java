package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.SeatTypeDto;
import com.ideas2it.bookmymovie.model.SeatType;
import com.ideas2it.bookmymovie.service.SeatTypeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/seatType")
public class SeatTypeController {
    private SeatTypeService seatTypeService;

    public SeatTypeController(SeatTypeService seatTypeService) {
        this.seatTypeService = seatTypeService;
    }

    /**
     * <p>
     * This method is used to create seatType Details
     * </p>
     *
     * @param seatTypeDto it contains genre dto objects
     * @return SeatTypeDto
     */
    @PostMapping
    public SeatTypeDto createSeatType(@Valid @RequestBody SeatTypeDto seatTypeDto) {
        return seatTypeService.addSeatType(seatTypeDto);
    }
}
