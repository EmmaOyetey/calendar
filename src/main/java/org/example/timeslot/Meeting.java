package org.example.timeslot;

import org.example.timeslot.TimeSlot;

public class Meeting extends TimeSlot{


    public Meeting(String startTime, String endTime) {
        super(startTime, endTime, TimeSlotStatus.BUSY);
    }

}
