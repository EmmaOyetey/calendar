package org.example.calendar;

import org.example.timeslot.Busy;

import java.time.LocalDateTime;

public class Pablo extends Calendar {
    public Pablo() {
        super("08:00", "18:00", "Pablo", LocalDateTime.now());
        addPredefinedMeetings();
    }

    private void addPredefinedMeetings() {
        // Add some meetings for the month of July
        addTimeSlot(new Busy(LocalDateTime.of(2024, 7, 3, 10, 0), LocalDateTime.of(2024, 7, 3, 11, 0)));
        addTimeSlot(new Busy(LocalDateTime.of(2024, 7, 10, 13, 0), LocalDateTime.of(2024, 7, 10, 14, 0)));
        addTimeSlot(new Busy(LocalDateTime.of(2024, 7, 24, 9, 0), LocalDateTime.of(2024, 7, 24, 10, 0)));
    }
}

//package org.example.calendar;
//
//import org.example.timeslot.Busy;
//
//import java.util.Date;
//
//public class Pablo extends Calendar {
//    public Pablo() {
//        super("08:00", "18:00", "Pablo", new Date());
//        addPredefinedMeetings();
//    }
//
//    private void addPredefinedMeetings() {
//        // Add some meetings for the month of July
//        addTimeSlot(new Busy("2024-07-03T10:00", "2024-07-03T11:00"));
//        addTimeSlot(new Busy("2024-07-10T13:00", "2024-07-10T14:00"));
//        addTimeSlot(new Busy("2024-07-24T09:00", "2024-07-24T10:00"));
//    }
//}