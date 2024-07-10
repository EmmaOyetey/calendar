package org.example.timeslot;

import java.time.LocalDateTime;

public class Busy extends TimeSlot {
    public Busy(LocalDateTime startTime, LocalDateTime endTime) {
        super(startTime, endTime, TimeSlotStatus.BUSY);
    }
}


//package org.example.timeslot;
//
//public class Busy extends TimeSlot{
//    public Busy(String startTime, String endTime) {
//        super(startTime, endTime, TimeSlotStatus.BUSY);
//    }
//
//}
