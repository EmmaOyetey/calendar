package org.example.calendar;

import org.example.timeslot.Busy;

import java.util.Date;

public class Emma extends Calendar {
    public Emma() {
        super("08:00", "18:00", "Emma", new Date());
        addPredefinedMeetings();
    }

    private void addPredefinedMeetings() {
        // Add some meetings for the month of July
        addTimeSlot(new Busy("2024-07-07T08:30", "2024-07-07T09:30"));
        addTimeSlot(new Busy("2024-07-14T11:30", "2024-07-14T12:30"));
        addTimeSlot(new Busy("2024-07-21T15:00", "2024-07-21T16:00"));
    }
}
