package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.BookedSeatDto;
import com.ideas2it.bookmymovie.dto.BookingDto;
import com.ideas2it.bookmymovie.exception.NotFoundException;
import com.ideas2it.bookmymovie.model.BookedSeat;
import com.ideas2it.bookmymovie.model.Booking;
import com.ideas2it.bookmymovie.repository.BookedSeatRepository;
import com.ideas2it.bookmymovie.service.BookedSeatService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookedSeatServiceImpl implements BookedSeatService {


    public  BookedSeatRepository bookedSeatRepository;

    private ModelMapper mapper;

    public BookedSeat bookedSeat;

    public BookedSeatDto bookedSeatDto;



    @Override
    public void createBookedSeat(BookedSeatDto bookedSeatDto) {
        BookedSeat bookedSeat = mapper.map(bookedSeatDto , BookedSeat.class);
        bookedSeatRepository.save(bookedSeat);
    }

    @Override
    public List<BookedSeatDto> getAllBookedSeats() throws NotFoundException {
        List<BookedSeat> bookedSeats = bookedSeatRepository.findAll();
        if (bookedSeats.isEmpty()) {
            throw new NotFoundException("No seats booked");
        }
        return bookedSeats.stream().map(bookedSeat -> mapper.map(bookedSeat, BookedSeatDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public BookedSeatDto getBookedSeatById(int id) throws NotFoundException {
        bookedSeat = bookedSeatRepository.findById(id);
        if (null == bookedSeat) {
            throw new NotFoundException("No seats booked");
        }
        return mapper.map(bookedSeat, BookedSeatDto.class);
    }

    @Override
    public BookedSeatDto updateBookedSeat(int id,boolean status) {
        bookedSeat = bookedSeatRepository.findById(id);
        bookedSeat.setModifiedDate(LocalDate.now());
        bookedSeat.setStatus(status);
        return mapper.map(bookedSeatRepository.save(bookedSeat),BookedSeatDto.class);
    }

    @Override
    public void cancelBookedSeatById(int id, boolean status) {
        /*bookedSeat = bookedSeatRepository.findBYId(id);
        bookedSeat.setModifiedDate(LocalDate.now());
        bookedSeat.setStatus(status);*/

    }
}
