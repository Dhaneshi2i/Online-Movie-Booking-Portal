package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.BookedSeatDto;
import com.ideas2it.bookmymovie.dto.BookingDto;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.BookedSeat;
import com.ideas2it.bookmymovie.repository.BookedSeatRepository;
import com.ideas2it.bookmymovie.service.BookedSeatService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookedSeatServiceImpl implements BookedSeatService {


    private final BookedSeatRepository bookedSeatRepository;

    private final MapStructMapper mapper;

   public BookedSeat bookedSeat;

   public BookedSeatDto bookedSeatDto;



    @Override
    public void createBookedSeat(BookedSeatDto bookedSeatDto) {
        //BookedSeat bookedSeat = mapper.map(bookedSeatDto , BookedSeat.class);
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
