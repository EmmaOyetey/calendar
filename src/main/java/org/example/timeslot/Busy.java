package org.example.timeslot;

public class Busy extends TimeSlot{
    public Busy(String startTime, String endTime) {
        super(startTime, endTime, TimeSlotStatus.BUSY);
    }

}
