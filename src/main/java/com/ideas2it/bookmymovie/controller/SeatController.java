package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.dto.SeatDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.service.SeatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
     *
     * @param seatDto
     * @return seatDetails
     * @throws NotFoundException
     */
    @PostMapping
    public ResponseEntity<SeatDto> addASeat(@RequestBody SeatDto seatDto)
            throws NotFoundException {

        seatDto = seatService.addSeat(seatDto);
        logger.info("-------Seat Added Successfully---------");
        return new ResponseEntity<>(seatDto, HttpStatus.CREATED);
    }

    /**
     *
     * @return listOfSeats
     * @throws NotFoundException
     */
    @GetMapping
    public ResponseEntity<List<SeatDto>> viewSeatList() throws NotFoundException {

        logger.info("-------List of Seats Fetched Successfully---------");
        return ResponseEntity.ok(seatService.viewSeatList());
    }

    /**
     *
     * @param seatId
     * @return updated seat
     * @throws NotFoundException
     */
    @PutMapping("/{seatId}")
    public ResponseEntity<SeatDto> updateSeat(@PathVariable("seatId") int seatId)
            throws NotFoundException {

        ResponseEntity<SeatDto> response = null;
        SeatDto seatDto = seatService.updateSeat(seatId);
        response = new ResponseEntity<>(seatDto, HttpStatus.OK);
        logger.info("-------Seat Updated Successfully---------");
        return response;
    }

    /**
     *
     * @param seatDto
     * @return booked seat
     * @throws NotFoundException
     */
    @PutMapping("/book")
    public ResponseEntity<SeatDto> BookASeat(@RequestBody SeatDto seatDto)
            throws NotFoundException {

        seatDto = seatService.bookSeat(seatDto);
        logger.info("-------Seat booking Successfull---------");
        return new ResponseEntity<>(seatDto, HttpStatus.OK);
    }

    /**
     *
     * @param seatDto
     * @return cancelled seat
     * @throws NotFoundException
     */
    @PutMapping("/cancel")
    public ResponseEntity<SeatDto> CancelASeat(@RequestBody SeatDto seatDto)
            throws NotFoundException {

        seatDto = seatService.cancelSeatBooking(seatDto);
        logger.info("-------Seat Cancellation Successfull---------");
        return new ResponseEntity<>(seatDto, HttpStatus.OK);
    }

    /**
     *
     * @param seat
     * @return blocked seat
     * @throws NotFoundException
     */
    @PutMapping("/block")
    public ResponseEntity<SeatDto> BloclASeat(@RequestBody SeatDto seat)
            throws NotFoundException {

        seat = seatService.blockSeat(seat);
        logger.info("-------Seat blocking Successfull---------");
        return new ResponseEntity<>(seat, HttpStatus.OK);

    }
}
