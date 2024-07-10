package org.example.manager;

import org.example.calendar.Calendar;
import org.example.timeslot.Busy;
import org.example.utilities.CommandLine;
import org.example.utilities.InputHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AddMeeting {
    private Calendar calendar;

    public AddMeeting(Calendar calendar) {
        this.calendar = calendar;
    }

    public void promptAndAddMeeting(CommandLine commandLine, InputHandler inputHandler) {
        commandLine.displayDayPrompt();
        int day = inputHandler.nextInt();

        commandLine.displayMonthPrompt();
        int month = inputHandler.nextInt();

        if (month < 1 || month > 12) {
            commandLine.displayMessage("Invalid month value. Month must be between 1 and 12.");
            return;
        }

        LocalTime startTime = promptForTime(commandLine, inputHandler, "start");
        LocalTime endTime = promptForTime(commandLine, inputHandler, "end");

        // Assuming the year is the current year for simplicity
        int year = LocalDate.now().getYear();
        LocalDateTime startDateTime = LocalDateTime.of(year, month, day, startTime.getHour(), startTime.getMinute());
        LocalDateTime endDateTime = LocalDateTime.of(year, month, day, endTime.getHour(), endTime.getMinute());

        // Add the meeting to the calendar
        Busy newMeeting = new Busy(startDateTime, endDateTime);
        calendar.addTimeSlot(newMeeting);

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedStartTime = startTime.format(timeFormatter);
        String formattedEndTime = endTime.format(timeFormatter);

        commandLine.meetingAddedSuccessMessage(day, month, formattedStartTime, formattedEndTime);
    }

    private LocalTime promptForTime(CommandLine commandLine, InputHandler inputHandler, String type) {
        while (true) {
            commandLine.displayPromptForTime(type);
            String timeInput = inputHandler.next();
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                return LocalTime.parse(timeInput, formatter);
            } catch (Exception e) {
                commandLine.displayInvalidTimeFormat();
            }
        }
    }
}
