package org.example.calendar;

import org.example.timeslot.Busy;

import java.util.Date;

public class Sam extends Calendar {
    public Sam() {
        super("08:00", "18:00", "Sam", new Date());
        addPredefinedMeetings();
    }

    private void addPredefinedMeetings() {

        addTimeSlot(new Busy("2024-07-05T09:00", "2024-07-05T10:00"));
        addTimeSlot(new Busy("2024-07-12T11:00", "2024-07-12T12:00"));
        addTimeSlot(new Busy("2024-07-19T14:00", "2024-07-19T15:00"));
    }
}
