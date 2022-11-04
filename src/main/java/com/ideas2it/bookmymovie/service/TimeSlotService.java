package com.ideas2it.bookmymovie.service;

import com.ideas2it.bookmymovie.dto.TimeSlotDto;
import com.ideas2it.bookmymovie.model.TimeSlot;

/**
 * <p>
 * This {@Code TimeSlotService} interface used for crud operations
 * </p>
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 */
public interface TimeSlotService {

    /**
     * <p>
     * This method is used to create TimeSlot detail
     * </p>
     *
     * @param timeSlotDto it contains timeSlot objects.
     * @return TimeSlotDto
     */
    TimeSlotDto addTimeSlot(TimeSlotDto timeSlotDto);

    /**
     * <p>
     * This method is used to create TimeSlot detail
     * </p>
     *
     * @param timeSlotId it contains timeSlot objects.
     * @return TimeSlotDto
     */
    TimeSlot getTimeSlotByTimeSlotId(int timeSlotId);
}
