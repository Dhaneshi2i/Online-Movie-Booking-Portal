package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.BookedSeatDto;
import com.ideas2it.bookmymovie.dto.BookingDto;
import com.ideas2it.bookmymovie.model.BookedSeat;
import com.ideas2it.bookmymovie.repository.BookedSeatRepository;
import com.ideas2it.bookmymovie.service.BookedSeatService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookedSeatServiceImpl implements BookedSeatService {

    private final BookedSeatRepository bookedSeatRepository;

    private final ModelMapper mapper;

    private final BookedSeat bookedSeat;

    private final BookedSeatDto bookedSeatDto;

    public BookedSeatServiceImpl(BookedSeatRepository bookedSeatRepository, ModelMapper mapper,
                                 BookedSeat bookedSeat, BookedSeatDto bookedSeatDto) {
        this.bookedSeatRepository = bookedSeatRepository;
        this.mapper = mapper;
        this.bookedSeat = bookedSeat;
        this.bookedSeatDto = bookedSeatDto;
    }


    @Override
    public void createBookedSeat(BookedSeatDto bookedSeatDto) {
        BookedSeat bookedSeat = mapper.map(bookedSeatDto , BookedSeat.class);
        bookedSeatRepository.save(bookedSeat);
    }

    @Override
    public List<BookingDto> getAllBookedSeats() {
        return null;
    }

    @Override
    public BookedSeatDto getBookedSeatById(int id) {
        return null;
    }

    @Override
    public BookedSeatDto updateBookedSeat(BookedSeatDto bookedSeatDto, int id) {
        return null;
    }

    @Override
    public void cancelBookedSeatById(int id) {

    }
}
