package com.ideas2it.bookmymovie.service.impl;

import com.ideas2it.bookmymovie.dto.TimeSlotDto;
import com.ideas2it.bookmymovie.mapper.MapStructMapper;
import com.ideas2it.bookmymovie.model.TimeSlot;
import com.ideas2it.bookmymovie.repository.TimeSlotRepository;
import com.ideas2it.bookmymovie.service.TimeSlotService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * This {@Code TimeSlotService} interface used for crud operations
 * </p>
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 */

@Service
public class TimeSlotServiceImpl implements TimeSlotService {

    private final TimeSlotRepository timeSlotRepository;
    private final MapStructMapper mapper;

    public TimeSlotServiceImpl(TimeSlotRepository timeSlotRepository, MapStructMapper mapper) {
        this.timeSlotRepository = timeSlotRepository;
        this.mapper = mapper;
    }

    /**
     * <p>
     * This method is used to create TimeSlot detail
     * </p>
     *
     * @param timeSlotDto it contains timeSlot objects.
     * @return TimeSlotDto
     */
    @Override
    public TimeSlotDto addTimeSlot(TimeSlotDto timeSlotDto) {
        return mapper.timeSlotToTimeSlotDto(timeSlotRepository.save(mapper.timeSlotDtoToTimeSlot(timeSlotDto)));
    }

    /**
     * <p>
     * This method is used to create TimeSlot detail
     * </p>
     *
     * @param timeSlotId it contains timeSlot objects.
     * @return TimeSlotDto
     */
    @Override
    public TimeSlot getTimeSlotByTimeSlotId(int timeSlotId) {
        return timeSlotRepository.findByTimeSlotId(timeSlotId);
    }
}
