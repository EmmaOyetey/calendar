package org.example.manager;

import org.example.calendar.Calendar;
import org.example.timeslot.TimeSlot;
import org.example.utilities.CalendarUtils;
import org.example.utilities.CommandLine;
import org.example.utilities.InputHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class FreeTimeSlotFinder {
    private Calendar calendar;
    private List<Calendar> allCalendars;

    public FreeTimeSlotFinder(Calendar calendar, List<Calendar> allCalendars) {
        this.calendar = calendar;
        this.allCalendars = allCalendars;
    }

    public void findFreeTimeSlot(CommandLine commandLine, InputHandler inputHandler) {
        displayCalendarOptions(commandLine);

        int choice = inputHandler.nextInt();

        if (choice < 0 || choice >= allCalendars.size()) {
            commandLine.displayInvalidInputMessage();
            return;
        }

        Calendar otherCalendar = allCalendars.get(choice);

        if (otherCalendar.equals(calendar)) {
            commandLine.displayMessage("You cannot select your own calendar.");
            return;
        }

        commandLine.displayDayPrompt();
        int day = inputHandler.nextInt();

        commandLine.displayMonthPrompt();
        int month = inputHandler.nextInt();

        List<TimeSlot> freeSlots = CalendarUtils.findAvailableSlots(calendar, otherCalendar, day, month);

        commandLine.displayAvailableSlots();
        for (TimeSlot slot : freeSlots) {
            commandLine.displayMeetingDetails(formatDateTime(slot.getStartTime()), formatDateTime(slot.getEndTime()));
        }
    }

    private void displayCalendarOptions(CommandLine commandLine) {
        commandLine.displayIdentifyOtherCalendarPrompt(calendar.getName());

        List<String> otherNames = allCalendars.stream()
                .map(Calendar::getName)
                .filter(name -> !name.equals(calendar.getName()))
                .collect(Collectors.toList());

        for (int i = 0; i < otherNames.size(); i++) {
            commandLine.displayMessage((i + 1) + ". " + otherNames.get(i));
        }
    }

    private String formatDateTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM HH:mm");
        return dateTime.format(formatter);
    }
}
