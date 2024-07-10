package org.example.calendar;

import java.time.LocalDateTime;

public class UserCalendar extends Calendar {
    public UserCalendar(String earliestTime, String latestTime, String name, LocalDateTime date) {
        super(earliestTime, latestTime, name, date);
    }
}
