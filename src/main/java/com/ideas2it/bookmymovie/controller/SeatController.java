package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.SeatDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.service.SeatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seat")
public class SeatController {
    Logger logger = LoggerFactory.getLogger(SeatController.class);

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }


    /**
     * @param seatDto
     * @return seatDetails
     * @throws NotFoundException
     */
    @PostMapping
    public SeatDto addASeat(@RequestBody SeatDto seatDto)
            throws NotFoundException {

        seatDto = seatService.addSeat(seatDto);
        logger.info("-------Seat Added Successfully---------");
        return seatDto;
    }

    /**
     * @return listOfSeats
     * @throws NotFoundException
     */
    @GetMapping
    public List<SeatDto> viewSeatList() throws NotFoundException {

        logger.info("-------List of Seats Fetched Successfully---------");
        return seatService.viewSeatList();
    }

    /**
     * @param seatId
     * @return updated seat
     * @throws NotFoundException
     */
    @PutMapping("/{seatId}")
    public SeatDto updateSeat(@PathVariable("seatId") int seatId)
            throws NotFoundException {
        SeatDto seatDto = seatService.updateSeat(seatId);
        logger.info("-------Seat Updated Successfully---------");
        return seatDto;
    }

    /**
     * @param seatDto
     * @return booked seat
     * @throws NotFoundException
     */
    @PutMapping("/book")
    public SeatDto BookASeat(@RequestBody SeatDto seatDto)
            throws NotFoundException {

        seatDto = seatService.bookSeat(seatDto);
        logger.info("-------Seat booking Successful---------");
        return seatDto;
    }

    /**
     * @param seatDto
     * @return cancelled seat
     * @throws NotFoundException
     */
    @PutMapping("/cancel")
    public SeatDto CancelASeat(@RequestBody SeatDto seatDto)
            throws NotFoundException {

        seatDto = seatService.cancelSeatBooking(seatDto);
        logger.info("-------Seat Cancellation Successfull---------");
        return seatDto;
    }

    /**
     * @param seat
     * @return blocked seat
     * @throws NotFoundException
     */
    @PutMapping("/block")
    public SeatDto BlockSeat(@RequestBody SeatDto seat)
            throws NotFoundException {

        seat = seatService.blockSeat(seat);
        logger.info("-------Seat blocking Successfull---------");
        return seat;

    }
}
