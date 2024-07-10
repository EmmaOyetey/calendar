package org.example.calendar;

import java.time.LocalDateTime;

public class UserCalendar extends Calendar {
    public UserCalendar(String earliestTime, String latestTime, String name, LocalDateTime date) {
        super(earliestTime, latestTime, name, date);
    }
}

//package org.example.calendar;
//
//import java.util.Date;
//
//public class UserCalendar extends Calendar {
//    public UserCalendar(String earliestTime, String latestTime, String name, Date date) {
//        super(earliestTime, latestTime, name, date);
//    }
//}
