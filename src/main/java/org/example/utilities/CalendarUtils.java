package org.example.utilities;

import org.example.calendar.Calendar;
import org.example.timeslot.Available;
import org.example.timeslot.TimeSlot;
import org.example.timeslot.TimeSlotStatus;

import java.util.ArrayList;
import java.util.List;

public class CalendarUtils {
    public static List<TimeSlot> findAvailableSlots(Calendar calendar1, Calendar calendar2, int day, int month) {
        List<TimeSlot> availableSlots = new ArrayList<>();

        // Simplistic approach: assuming the slots are added in chronological order
        for (TimeSlot slot1 : calendar1.getTimeSlots()) {
            if (slot1.getStatus() == TimeSlotStatus.AVAILABLE) {
                for (TimeSlot slot2 : calendar2.getTimeSlots()) {
                    if (slot2.getStatus() == TimeSlotStatus.AVAILABLE &&
                            slot1.getStartTime().equals(slot2.getStartTime()) &&
                            slot1.getEndTime().equals(slot2.getEndTime())) {
                        availableSlots.add(new Available(slot1.getStartTime(), slot1.getEndTime()));
                    }
                }
            }
        }

        return availableSlots;
    }
}
