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
