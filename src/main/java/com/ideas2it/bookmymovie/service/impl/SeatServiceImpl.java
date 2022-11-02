package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.SeatDto;
import com.ideas2it.bookmymovie.dto.responseDto.SeatResponseDto;
import com.ideas2it.bookmymovie.exception.AlreadyExistException;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.Seat;
import com.ideas2it.bookmymovie.model.SeatStatus;
import com.ideas2it.bookmymovie.model.Show;
import com.ideas2it.bookmymovie.repository.SeatRepository;
import com.ideas2it.bookmymovie.service.SeatService;
import com.ideas2it.bookmymovie.service.ShowService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;
    private final ShowService showService;
    private final MapStructMapper mapper;

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
        seatRepository.save(seat);
    }

    /**
     * <p>
     * This method List all the Seat Details
     * </p>
     *
     * @return List<SeatDto>
     */
    @Override
    public List<SeatDto> getAllSeat(int pageNumber, int pageSize) throws NotFoundException {
        List<Seat> seats = seatRepository.findBySeatStatus(SeatStatus.AVAILABLE);

        if (0 == seats.size()) {
            throw new NotFoundException("No seats found");
        } else {
            Pageable p = PageRequest.of(pageNumber, pageSize);
            Page<Seat> seat = seatRepository.findAll(p);
            return  mapper.seatListToSeatDtoList(seat.getContent());

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
    @CachePut(value = "seat", key = "#seatId")
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
    @Transactional
    public Seat bookSeat(Seat seat) {
        Seat currentSeat = seatRepository.findBySeatId(seat.getSeatId());
        if (currentSeat.getSeatStatus().equals(SeatStatus.BOOKED)) {
            throw new AlreadyExistException("This seat is already booked, please choose a different seat");
        }
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
    @Cacheable(value = "seat",key = "#showId")
    public List<SeatResponseDto> getSeatByShowId(int showId) {
        Show show = mapper.showDtoToShow(showService.getShowById(showId));
        List<Seat> seats = new ArrayList<>();
        for (Seat seat : seatRepository.findByShow(show)) {
            if (seat.getSeatStatus().equals(SeatStatus.AVAILABLE)) {
                seats.add(seat);
            }
        }
        if (seats.isEmpty()) {
            throw new NotFoundException("No available seats found for this show");
        }
        return mapper.seatListToSeatResponseDtoList(seats);
    }

}
