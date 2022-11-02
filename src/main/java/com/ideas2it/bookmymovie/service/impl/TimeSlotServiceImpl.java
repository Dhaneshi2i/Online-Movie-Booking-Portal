package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.TimeSlotDto;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.TimeSlot;
import com.ideas2it.bookmymovie.repository.TimeSlotRepository;
import com.ideas2it.bookmymovie.service.TimeSlotService;
import org.springframework.stereotype.Service;

@Service
public class TimeSlotServiceImpl implements TimeSlotService {

    private final TimeSlotRepository timeSlotRepository;
    private final MapStructMapper mapper;

    public TimeSlotServiceImpl(TimeSlotRepository timeSlotRepository, MapStructMapper mapper) {
        this.timeSlotRepository = timeSlotRepository;
        this.mapper = mapper;
    }

    @Override
    public TimeSlotDto addTimeSlot(TimeSlotDto timeSlotDto) {
        return mapper.timeSlotToTimeSlotDto(timeSlotRepository.save(mapper.timeSlotDtoToTimeSlot(timeSlotDto)));
    }

    @Override
    public TimeSlot getTimeSlotByTimeSlotId(int timeSlotId) {
        return timeSlotRepository.findByTimeSlotId(timeSlotId);
    }
}
