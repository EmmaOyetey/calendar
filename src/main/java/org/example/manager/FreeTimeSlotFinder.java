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
    private CommandLine commandLine;
    private InputHandler inputHandler;

    public FreeTimeSlotFinder(Calendar calendar, List<Calendar> allCalendars) {
        this.calendar = calendar;
        this.allCalendars = allCalendars;
        this.commandLine = commandLine;
        this.inputHandler = inputHandler;
    }

    public void findFreeTimeSlot(CommandLine commandLine, InputHandler inputHandler) {
        displayCalendarOptions();

        // Get user's choice
        int choice = inputHandler.nextInt() - 1;

        if (choice < 0 || choice >= allCalendars.size()) {
            commandLine.displayInvalidInputMessage();
            return;
        }

        Calendar otherCalendar = allCalendars.get(choice);

        if (otherCalendar.equals(calendar)) {
            commandLine.displayMessage("You cannot select your own calendar.");
            return;
        }

        commandLine.displayIdentifyDatePrompt(calendar.getName());
        String dateInput = inputHandler.nextLine();
        LocalDateTime dateTime = parseDateTime(dateInput);

        if (dateTime == null) {
            commandLine.displayMessage("Invalid date format. Please use dd/MM.");
            return;
        }

        // Find common free slots
        List<TimeSlot> freeSlots = CalendarUtils.findAvailableSlots(calendar, otherCalendar, dateTime.getDayOfMonth(), dateTime.getMonthValue());

        commandLine.displayAvailableSlots();
        for (TimeSlot slot : freeSlots)
            commandLine.displayMeetingDetails(formatDateTime(slot.getStartTime()), formatDateTime(slot.getEndTime()));
    }

    private void displayCalendarOptions() {
        commandLine.displayIdentifyOtherCalendarPrompt(calendar.getName());

        List<String> otherNames = allCalendars.stream()
                .map(Calendar::getName)
                .filter(name -> !name.equals(calendar.getName()))
                .collect(Collectors.toList());

        // Display options with numbers
        for (int i = 0; i < otherNames.size(); i++) {
            commandLine.displayMessage((i + 1) + ". " + otherNames.get(i));
        }
    }

    private LocalDateTime parseDateTime(String dateInput) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");
            return LocalDateTime.parse(dateInput, formatter);
        } catch (Exception e) {
            return null;
        }
    }

    private String formatDateTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM HH:mm");
        return dateTime.format(formatter);
    }
}


//package org.example.manager;
//
//import org.example.calendar.Calendar;
//import org.example.timeslot.TimeSlot;
//import org.example.utilities.CalendarUtils;
//import org.example.utilities.CommandLine;
//import org.example.utilities.InputHandler;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class FreeTimeSlotFinder {
//    private Calendar calendar;
//    private List<Calendar> allCalendars;
//
//    public FreeTimeSlotFinder(Calendar calendar, List<Calendar> allCalendars) {
//        this.calendar = calendar;
//        this.allCalendars = allCalendars;
//    }
//
////    public void findFreeTimeSlot(CommandLine commandLine, InputHandler inputHandler) {
////        commandLine.displayIdentifyOtherCalendarPrompt(calendar.getName());
////
////        List<String> otherNames = allCalendars.stream()
////                .map(Calendar::getName)
////                .filter(name -> !name.equals(calendar.getName()))
////                .collect(Collectors.toList());
////
////        // Display options with numbers
////        for (int i = 0; i < otherNames.size(); i++) {
////            System.out.println((i + 1) + ". " + otherNames.get(i));
////        }
////
////        // Get user's choice
////        int choice = inputHandler.nextInt() - 1;
////
////        if (choice < 0 || choice >= otherNames.size()) {
////            System.out.println("Invalid choice. Please try again.");
////            return;
////        }
////
////        String otherPersonName = otherNames.get(choice);
////
////        Calendar otherCalendar = allCalendars.stream()
////                .filter(cal -> cal.getName().equalsIgnoreCase(otherPersonName))
////                .findFirst()
////                .orElse(null);
////
////        if (otherCalendar == null) {
////            System.out.println("Calendar not found for " + otherPersonName);
////            return;
////        }
////
////        commandLine.displayIdentifyDatePrompt(calendar.getName());
////        String dateInput = inputHandler.next();
////        String[] dateParts = dateInput.split("/");
////        int day = Integer.parseInt(dateParts[0]);
////        int month = Integer.parseInt(dateParts[1]);
////
////        // Find common free slots
////        List<TimeSlot> freeSlots = CalendarUtils.findAvailableSlots(calendar, otherCalendar, day, month);
////
////        commandLine.displayAvailableSlots();
////        for (TimeSlot slot : freeSlots) {
////            System.out.println(slot);
////        }
////    }
//}
