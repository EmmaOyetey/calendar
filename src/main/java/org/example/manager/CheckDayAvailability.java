package org.example.manager;

import org.example.calendar.Calendar;
import org.example.timeslot.TimeSlot;
import org.example.timeslot.TimeSlotStatus;
import org.example.utilities.CommandLine;
import org.example.utilities.InputHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckDayAvailability {
    private Calendar calendar;

    public CheckDayAvailability(Calendar calendar) {
        this.calendar = calendar;
    }

    public void checkAvailability(CommandLine commandLine, InputHandler inputHandler) {
        commandLine.displayAvailabilityMenu();
        int choice = inputHandler.nextInt();

        if (choice == 1) {
            commandLine.checkSpecificDayPrompt();
            int day = inputHandler.nextInt();
            commandLine.checkSpecificMonthPrompt();
            int month = inputHandler.nextInt();
            displayMeetingsForDay(commandLine, day, month);
        } else if (choice == 2) {
            displayAllMeetings(commandLine);
        } else {
            commandLine.displayInvalidInputMessage();
        }
    }

    private void displayMeetingsForDay(CommandLine commandLine, int day, int month) {
        commandLine.displayMessage("Meetings on " + day + "/" + month + " for " + calendar.getName() + ":");
        boolean meetingFound = false;
        for (TimeSlot timeSlot : calendar.getTimeSlots()) {
            if (isMeetingOnDayAndMonth(timeSlot, day, month)) {
                commandLine.displayMessage(formatTimeSlot(timeSlot));
                meetingFound = true;
            }
        }
        if (!meetingFound) {
            commandLine.displayMessage("No meetings found on " + day + "/" + month + ".");
        }
    }

    private void displayAllMeetings(CommandLine commandLine) {
        commandLine.displayMessage("All meetings for " + calendar.getName() + ":");
        for (TimeSlot timeSlot : calendar.getTimeSlots()) {
            if (timeSlot.getStatus() == TimeSlotStatus.BUSY) {
                commandLine.displayMessage(formatTimeSlot(timeSlot));
            }
        }
    }

    private boolean isMeetingOnDayAndMonth(TimeSlot timeSlot, int day, int month) {
        LocalDateTime slotDateTime = timeSlot.getStartTime();
        return slotDateTime.getDayOfMonth() == day &&
                slotDateTime.getMonthValue() == month;
    }

    private String formatTimeSlot(TimeSlot timeSlot) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MMM");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        return "Meeting: " + timeSlot.getStartTime().format(dateFormatter) +
                " Start Time: " + timeSlot.getStartTime().format(timeFormatter) +
                " End Time: " + timeSlot.getEndTime().format(timeFormatter);
    }
}

//package org.example.manager;
//
//import org.example.calendar.Calendar;
//import org.example.timeslot.TimeSlot;
//import org.example.timeslot.TimeSlotStatus;
//import org.example.utilities.CommandLine;
//import org.example.utilities.InputHandler;
//
//import java.util.List;
//
//public class CheckDayAvailability {
//    private Calendar calendar;
//
//    public CheckDayAvailability(Calendar calendar) {
//        this.calendar = calendar;
//    }
//
//    public void checkAvailability(CommandLine commandLine, InputHandler inputHandler) {
//        commandLine.displayMessage("Would you like to check availability for a specific day or see all meetings?");
//        commandLine.displayMessage("1. Specific day");
//        commandLine.displayMessage("2. All meetings");
//        int choice = inputHandler.nextInt();
//
//        if (choice == 1) {
//            commandLine.displayDayPrompt();
//            int day = inputHandler.nextInt();
//            commandLine.displayMonthPrompt();
//            int month = inputHandler.nextInt();
//
//            displayMeetingsForDay(commandLine, day, month);
//        } else if (choice == 2) {
//            displayAllMeetings(commandLine);
//        } else {
//            commandLine.displayMessage("Invalid choice. Please try again.");
//        }
//    }
//
//    private void displayMeetingsForDay(CommandLine commandLine, int day, int month) {
//        commandLine.displayMessage("Meetings on " + day + "/" + month + " for " + calendar.getName() + ":");
//        boolean meetingFound = false;
//        for (TimeSlot timeSlot : calendar.getTimeSlots()) {
//            if (isMeetingOnDate(timeSlot, day, month)) {
//                commandLine.displayMessage(timeSlot.toString());
//                meetingFound = true;
//            }
//        }
//        if (!meetingFound) {
//            commandLine.displayMessage("No meetings found on this date.");
//        }
//    }
//
//    private void displayAllMeetings(CommandLine commandLine) {
//        commandLine.displayMessage("All meetings for " + calendar.getName() + ":");
//        for (TimeSlot timeSlot : calendar.getTimeSlots()) {
//            if (timeSlot.getStatus() == TimeSlotStatus.BUSY) {
//                commandLine.displayMessage(timeSlot.toString());
//            }
//        }
//    }
//
//    private boolean isMeetingOnDate(TimeSlot timeSlot, int day, int month) {
//        // Assuming the startTime is in the format "YYYY-MM-DDTHH:mm"
//        String[] dateTimeParts = timeSlot.getStartTime().split("T")[0].split("-");
//        int meetingDay = Integer.parseInt(dateTimeParts[2]);
//        int meetingMonth = Integer.parseInt(dateTimeParts[1]);
//        return meetingDay == day && meetingMonth == month;
//    }
//}

//package org.example.manager;
//
//import org.example.calendar.Calendar;
//import org.example.timeslot.Busy;
//import org.example.timeslot.TimeSlot;
//import org.example.utilities.CommandLine;
//
//import java.text.SimpleDateFormat;
//
//public class CheckDayAvailability {
//    private Calendar calendar;
//
//    public CheckDayAvailability(Calendar calendar) {
//        this.calendar = calendar;
//    }
//
//    public void displayMeetings(CommandLine commandLine) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd, MMMM, HH:mm, HH:mm");
//        for (TimeSlot timeSlot : calendar.getTimeSlots()) {
//            if (timeSlot instanceof Busy) {
//                Busy busySlot = (Busy) timeSlot;
//                String formattedStartTime = dateFormat.format(busySlot.getStartTime());
//                String formattedEndTime = dateFormat.format(busySlot.getEndTime());
//                commandLine.displayMeetingDetails(formattedStartTime, formattedEndTime);
//            }
//        }
//    }
//}