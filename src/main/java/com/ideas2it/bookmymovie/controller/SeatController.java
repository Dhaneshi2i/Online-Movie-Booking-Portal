package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.SeatDto;
import com.ideas2it.bookmymovie.service.SeatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * SeatController will get the seat detail to
 * Create seats for the user,list all seats and
 * Update seats with given status
 * </p>
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 **/
@RestController
@RequestMapping("api/v1/seat")
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    /**
     * <p>
     * This method List all the Seat Details
     * </p>
     *
     * @return List<SeatDto>
     */
    @GetMapping
    public List<SeatDto> viewSeatList(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        return seatService.getAllSeat(pageNumber, pageSize);
    }

    /**
     * <p>
     * This method updates the Seat Details
     * </p>
     *
     * @param seatId it contains seat id
     * @return SeatDto
     */
    @PatchMapping("/{seatId}")
    public SeatDto updateSeat(@PathVariable("seatId") int seatId) {
        return seatService.updateSeatById(seatId);
    }

}