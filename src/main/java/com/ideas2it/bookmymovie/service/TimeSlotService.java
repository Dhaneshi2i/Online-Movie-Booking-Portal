package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.TimeSlotDto;
import com.ideas2it.bookmymovie.model.TimeSlot;

public interface TimeSlotService {
    TimeSlotDto addTimeSlot(TimeSlotDto timeSlotDto);
    TimeSlot getTimeSlotByTimeSlotId(int timeSlotId);
}
