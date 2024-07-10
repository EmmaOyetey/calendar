package org.example.timeslot;

import java.time.LocalDateTime;

public class Available extends TimeSlot {
    public Available(LocalDateTime startTime, LocalDateTime endTime) {
        super(startTime, endTime, TimeSlotStatus.AVAILABLE);
    }
}

//package org.example.timeslot;
//
//public class Available extends TimeSlot {
//    public Available(String startTime, String endTime) {
//        super(startTime, endTime, TimeSlotStatus.AVAILABLE);
//    }
//
//}
