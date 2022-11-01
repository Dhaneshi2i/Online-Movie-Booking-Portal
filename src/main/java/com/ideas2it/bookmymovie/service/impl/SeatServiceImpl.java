package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.SeatDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Seat;
import com.ideas2it.bookmymovie.model.SeatStatus;
import com.ideas2it.bookmymovie.model.Show;
import com.ideas2it.bookmymovie.repository.SeatRepository;
import com.ideas2it.bookmymovie.service.SeatService;
import com.ideas2it.bookmymovie.service.ShowService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SeatServiceImpl implements SeatService {

    private SeatRepository seatRepository;
    private ShowService showService;
    private MapStructMapper mapper;

    public SeatServiceImpl(SeatRepository seatRepository, @Lazy ShowService showService, MapStructMapper mapper) {
        this.seatRepository = seatRepository;
        this.showService = showService;
        this.mapper = mapper;
    }

    /**
     * <p>
     * This method is used to create Seat Details
     * </p>
     *
     * @param seat it contains seat objects
     */
    @Override
    @Transactional
    public void createSeat(Seat seat)  {
        seatRepository.saveAndFlush(seat);
    }

    /**
     * <p>
     * This method List all the Seat Details
     * </p>
     *
     * @return List<SeatDto>
     */
    @Override
    public List<SeatDto> getAllSeat() throws NotFoundException {
        List<Seat> seats = seatRepository.findBySeatStatus(SeatStatus.AVAILABLE);

        if (0 == seats.size()) {
            throw new NotFoundException("No seats found");
        } else {
            return mapper.seatListToSeatDtoList(seats);
        }
    }

    /**
     * <p>
     * This method updates the Seat Details
     * </p>
     *
     * @param seatId it contains seat id
     * @return SeatDto
     */
    @Override
    public SeatDto updateSeatById(int seatId) throws NotFoundException{
        Optional<Seat> seat = seatRepository.findById(seatId);
        if(seat.isPresent()) {
            seat.get().setSeatStatus(SeatStatus.BLOCKED);
            return mapper.seatToSeatDto(seatRepository.save(seat.get()));
        }
        throw new NotFoundException("Seat with the given id is not present");
    }

    /**
     * <p>
     * This method is used to book Seats
     * </p>
     *
     * @param seat it contains seat objects
     * @return SeatDto
     */
    @Override
    public Seat bookSeat(Seat seat) {
        seat.setSeatStatus(SeatStatus.BOOKED);
        return seatRepository.save(seat);
    }

    /**
     * <p>
     * This method is used to cancel Seats
     * </p>
     *
     * @param seat it contains seat objects
     * @return SeatDto
     */
    @Override
    public Seat cancelSeatBooking(Seat seat) {
        seat.setSeatStatus(SeatStatus.AVAILABLE);
        return seatRepository.save(seat);
    }

    /**
     * <p>
     * This method gets the Seat Details
     * </p>
     *
     * @param seatId it contains seat id
     * @return SeatDto
     */
    @Override
    public Seat getSeatById(int seatId) {
        return seatRepository.findBySeatId(seatId);
    }

    /**
     * <p>
     * This method List all the Seat Details with given showId
     * </p>
     *
     * @param showId it contains show id
     * @return List<SeatDto>
     */
    @Override
    public List<SeatDto> getSeatByShowId(int showId) {
        Show show = mapper.showDtoToShow(showService.getShowById(showId));
        List<Seat> seats = seatRepository.findByShow(show);
        return mapper.seatListToSeatDtoList(seats);
    }

}
