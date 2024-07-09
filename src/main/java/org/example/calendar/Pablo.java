package org.example.calendar;

import org.example.timeslot.Busy;

import java.util.Date;

public class Pablo extends Calendar {
    public Pablo() {
        super("08:00", "18:00", "Pablo", new Date());
        addPredefinedMeetings();
    }

    private void addPredefinedMeetings() {
        // Add some meetings for the month of July
        addTimeSlot(new Busy("2024-07-03T10:00", "2024-07-03T11:00"));
        addTimeSlot(new Busy("2024-07-10T13:00", "2024-07-10T14:00"));
        addTimeSlot(new Busy("2024-07-24T09:00", "2024-07-24T10:00"));
    }
}