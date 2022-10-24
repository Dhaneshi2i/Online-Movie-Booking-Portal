package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.SeatDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.service.SeatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/seat")
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }


    /**
     * @param seatDto
     * @return seatDetails
     */

    @PostMapping
    public SeatDto addSeat(@Valid @RequestBody SeatDto seatDto) {
        return seatService.createSeat(seatDto);
    }

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
    @PutMapping("/{seatId}")
    public SeatDto updateSeat(@PathVariable("seatId") int seatId)
            throws NotFoundException {
        SeatDto seatDto = seatService.updateSeatById(seatId);
        return seatDto;
    }

    /**
     * @param seatDto
     * @return booked seat
     * @throws NotFoundException
    @PutMapping("/book")
    public SeatDto BookASeat(@RequestBody SeatDto seatDto)
            throws NotFoundException {

        seatDto = seatService.bookSeat(seatDto);
        logger.info("-------Seat booking Successful---------");
        return seatDto;
    }*/

    /**
     * @param seatDto
     * @return cancelled seat
     * @throws NotFoundException
    @PutMapping("/cancel")
    public SeatDto CancelASeat(@RequestBody SeatDto seatDto)
            throws NotFoundException {

        seatDto = seatService.cancelSeatBooking(seatDto);
        logger.info("-------Seat Cancellation Successfull---------");
        return seatDto;
    }*/

    /**
     * @param seat
     * @return blocked seat
     * @throws NotFoundException
     */
   /* @PutMapping("/block")
    public SeatDto BlockSeat(@RequestBody SeatDto seat)
            throws NotFoundException {

        seat = seatService.blockSeat(seat);
        logger.info("-------Seat blocking Successfull---------");
        return seat;

    }*/
}
