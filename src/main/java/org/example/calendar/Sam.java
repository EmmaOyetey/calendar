package org.example.calendar;

import org.example.timeslot.Busy;

import java.time.LocalDateTime;

public class Sam extends Calendar {
    public Sam() {
        super("08:00", "18:00", "Sam", LocalDateTime.now());
        addPredefinedMeetings();
    }

    private void addPredefinedMeetings() {

        addTimeSlot(new Busy(LocalDateTime.of(2024, 7, 5, 9, 0), LocalDateTime.of(2024, 7, 5, 10, 0)));
        addTimeSlot(new Busy(LocalDateTime.of(2024, 7, 12, 11, 0), LocalDateTime.of(2024, 7, 12, 12, 0)));
        addTimeSlot(new Busy(LocalDateTime.of(2024, 7, 19, 14, 0), LocalDateTime.of(2024, 7, 19, 15, 0)));
    }
}
