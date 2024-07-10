package org.example.utilities;

import org.example.calendar.Calendar;
import org.example.timeslot.TimeSlot;
import org.example.timeslot.TimeSlotStatus;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CalendarUtils {
    public static List<TimeSlot> findAvailableSlots(Calendar calendar1, Calendar calendar2, int day, int month) {
        List<TimeSlot> availableSlots = new ArrayList<>();

        LocalTime earliestStartTime = LocalTime.parse(calendar1.getEarliestTime(), DateTimeFormatter.ofPattern("HH:mm"));
        LocalTime latestEndTime = LocalTime.parse(calendar1.getLatestTime(), DateTimeFormatter.ofPattern("HH:mm"));

        for (LocalTime time = earliestStartTime; !time.isAfter(latestEndTime); time = time.plusMinutes(30)) {
            LocalDateTime startTime = LocalDateTime.of(LocalDateTime.now().getYear(), month, day, time.getHour(), time.getMinute());
            LocalDateTime endTime = startTime.plusMinutes(30);

            if (isTimeSlotAvailable(calendar1, startTime, endTime) && isTimeSlotAvailable(calendar2, startTime, endTime)) {
                availableSlots.add(new TimeSlot(startTime, endTime, TimeSlotStatus.AVAILABLE));
            }
        }

        return availableSlots;
    }

    private static boolean isTimeSlotAvailable(Calendar calendar, LocalDateTime startTime, LocalDateTime endTime) {
        for (TimeSlot slot : calendar.getTimeSlots()) {
            if (slot.getStatus() == TimeSlotStatus.BUSY &&
                    (slot.getStartTime().isBefore(endTime) && slot.getEndTime().isAfter(startTime))) {
                return false;
            }
        }
        return true;
    }
}

//package org.example.utilities;
//
//import org.example.calendar.Calendar;
//import org.example.timeslot.Available;
//import org.example.timeslot.TimeSlot;
//import org.example.timeslot.TimeSlotStatus;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class CalendarUtils {
//    public static List<TimeSlot> findAvailableSlots(Calendar calendar1, Calendar calendar2, int day, int month) {
//        List<TimeSlot> availableSlots = new ArrayList<>();
//
//        // Simplistic approach: assuming the slots are added in chronological order
//        for (TimeSlot slot1 : calendar1.getTimeSlots()) {
//            if (slot1.getStatus() == TimeSlotStatus.AVAILABLE) {
//                for (TimeSlot slot2 : calendar2.getTimeSlots()) {
//                    if (slot2.getStatus() == TimeSlotStatus.AVAILABLE &&
//                            slot1.getStartTime().equals(slot2.getStartTime()) &&
//                            slot1.getEndTime().equals(slot2.getEndTime())) {
//                        availableSlots.add(new Available(slot1.getStartTime(), slot1.getEndTime()));
//                    }
//                }
//            }
//        }
//
//        return availableSlots;
//    }
//}
