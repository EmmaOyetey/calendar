package org.example.timeslot;

import java.time.LocalDateTime;

public class Available extends TimeSlot {
    public Available(LocalDateTime startTime, LocalDateTime endTime) {
        super(startTime, endTime, TimeSlotStatus.AVAILABLE);
    }
}
