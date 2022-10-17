package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.BookedSeatDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.BookedSeat;
import com.ideas2it.bookmymovie.repository.BookedSeatRepository;
import com.ideas2it.bookmymovie.service.BookedSeatService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class BookedSeatServiceImpl implements BookedSeatService {
    private final BookedSeatRepository bookedSeatRepository;
    private final MapStructMapper mapper;
    public BookedSeat bookedSeat;
    public BookedSeatDto bookedSeatDto;
    public BookedSeatServiceImpl(BookedSeatRepository bookedSeatRepository, MapStructMapper mapper, BookedSeat bookedSeat, BookedSeatDto bookedSeatDto) {
        this.bookedSeatRepository = bookedSeatRepository;
        this.mapper = mapper;
        this.bookedSeat = bookedSeat;
        this.bookedSeatDto = bookedSeatDto;
    }

    @Override
    public void createBookedSeat(BookedSeatDto bookedSeatDto) {
        //BookedSeat bookedSeat = mapper.map(bookedSeatDto , BookedSeat.class);
        bookedSeatRepository.save(bookedSeat);
    }

    @Override
    public List<BookedSeatDto> getAllBookedSeats() throws NotFoundException {
        List<BookedSeat> bookedSeats = bookedSeatRepository.findAll();
        if (bookedSeats.isEmpty()) {
            throw new NotFoundException("No seats booked");
        }
        return bookedSeats.stream().map(bookedSeat -> mapper.bookedSeatToBookedSeatDto(bookedSeat))
                .collect(Collectors.toList());
    }

    @Override
    public BookedSeatDto getBookedSeatById(int id) throws NotFoundException {
        bookedSeat = bookedSeatRepository.findById(id);
        if (null == bookedSeat) {
            throw new NotFoundException("No seats booked");
        }
        return mapper.bookedSeatToBookedSeatDto(bookedSeat);
    }

    @Override
    public BookedSeatDto updateBookedSeat(int id,boolean status) {
        bookedSeat = bookedSeatRepository.findById(id);
        bookedSeat.setModifiedDate(LocalDate.now());
        bookedSeat.setStatus(status);
        return mapper.bookedSeatToBookedSeatDto(bookedSeatRepository.save(bookedSeat));
    }

    @Override
    public void cancelBookedSeatById(int id, boolean status) {
        /*bookedSeat = bookedSeatRepository.findBYId(id);
        bookedSeat.setModifiedDate(LocalDate.now());
        bookedSeat.setStatus(status);*/
    }
}
