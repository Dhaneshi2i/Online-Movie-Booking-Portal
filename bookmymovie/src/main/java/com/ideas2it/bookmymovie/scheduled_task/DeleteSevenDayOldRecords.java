package com.ideas2it.bookmymovie.scheduled_task;

import com.ideas2it.bookmymovie.repository.ScreeningRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@Component
public class DeleteSevenDayOldRecords {
    private ScreeningRepository screeningRepository;

    public DeleteSevenDayOldRecords(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    /*
     * This method uses cron 0 0 0 * * ? (run every day midnight) to delete screenings which are already 7 days old.
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void deleteSevenDayOldScreening() {
        LocalDate today = LocalDate.now();

        screeningRepository.deleteAllInBatch(screeningRepository.findAll().stream()
                .filter(screening -> DAYS.between(screening.getShowDate(), today) > 7).collect(Collectors.toList()));
    }
}
