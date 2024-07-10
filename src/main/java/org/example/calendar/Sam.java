package org.example.calendar;

import org.example.timeslot.Busy;

import java.time.LocalDateTime;

public class Sam extends Calendar {
    public Sam() {
        super("08:00", "18:00", "Sam", LocalDateTime.now());
        addPredefinedMeetings();
    }

    private void addPredefinedMeetings() {
        // Add some meetings for the month of July
        addTimeSlot(new Busy(LocalDateTime.of(2024, 7, 5, 9, 0), LocalDateTime.of(2024, 7, 5, 10, 0)));
        addTimeSlot(new Busy(LocalDateTime.of(2024, 7, 12, 11, 0), LocalDateTime.of(2024, 7, 12, 12, 0)));
        addTimeSlot(new Busy(LocalDateTime.of(2024, 7, 19, 14, 0), LocalDateTime.of(2024, 7, 19, 15, 0)));
    }
}

//package org.example.calendar;
//
//import org.example.timeslot.Busy;
//
//import java.util.Date;
//
//public class Sam extends Calendar {
//    public Sam() {
//        super("08:00", "18:00", "Sam", new Date());
//        addPredefinedMeetings();
//    }
//
//    private void addPredefinedMeetings() {
//
//        addTimeSlot(new Busy("2024-07-05T09:00", "2024-07-05T10:00"));
//        addTimeSlot(new Busy("2024-07-12T11:00", "2024-07-12T12:00"));
//        addTimeSlot(new Busy("2024-07-19T14:00", "2024-07-19T15:00"));
//    }
//}
