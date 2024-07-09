package org.example.timeslot;

public class Available extends TimeSlot {
    public Available(String startTime, String endTime) {
        super(startTime, endTime, TimeSlotStatus.AVAILABLE);
    }

}
