package org.example.calendar;

import org.example.timeslot.Busy;

import java.time.LocalDateTime;

public class Emma extends Calendar {
    public Emma() {
        super("08:00", "18:00", "Emma", LocalDateTime.now());
        addPredefinedMeetings();
    }

    private void addPredefinedMeetings() {
        // Add some meetings for the month of July
        addTimeSlot(new Busy(LocalDateTime.of(2024, 7, 7, 8, 30), LocalDateTime.of(2024, 7, 7, 9, 30)));
        addTimeSlot(new Busy(LocalDateTime.of(2024, 7, 14, 11, 30), LocalDateTime.of(2024, 7, 14, 12, 30)));
        addTimeSlot(new Busy(LocalDateTime.of(2024, 7, 21, 15, 0), LocalDateTime.of(2024, 7, 21, 16, 0)));
    }
}


//import java.util.Date;
//
//public class Emma extends Calendar {
//    public Emma() {
//        super("08:00", "18:00", "Emma", new Date());
//        addPredefinedMeetings();
//    }
//
//    private void addPredefinedMeetings() {
//        // Add some meetings for the month of July
//        addTimeSlot(new Busy("2024-07-07T08:30", "2024-07-07T09:30"));
//        addTimeSlot(new Busy("2024-07-14T11:30", "2024-07-14T12:30"));
//        addTimeSlot(new Busy("2024-07-21T15:00", "2024-07-21T16:00"));
//    }
//}