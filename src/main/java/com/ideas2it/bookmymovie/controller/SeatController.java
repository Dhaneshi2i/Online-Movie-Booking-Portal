package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.SeatDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.service.SeatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/seat")
public class SeatController {

    private SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }


    /**
     * @param seatDto
     * @return seatDetails
     */

    /*@PostMapping
    public SeatDto addSeat(@Valid @RequestBody SeatDto seatDto) {
        return seatService.createSeat(seatDto);
    }*/

    /**
     * @return listOfSeats
     * @throws NotFoundException
     */
    @GetMapping
    public List<SeatDto> viewSeatList() throws NotFoundException {
        return seatService.getAllSeat();
    }

    /**
     * @param seatId
     * @return updated seat
     * @throws NotFoundException
     */
    @PutMapping("/{seatId}/{status}")
    public SeatDto updateSeat(@PathVariable("seatId") int seatId, @PathVariable("status") String status)
            throws NotFoundException {
        SeatDto seatDto = seatService.updateSeatById(seatId);
        return seatDto;
    }

    @GetMapping("/{showId}")
    public List<SeatDto> getSeatsByShow(@PathVariable int showId) {
        return seatService.getSeatByShowId(showId);
    }
}
