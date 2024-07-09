package org.example.manager;

import org.example.calendar.Calendar;
import org.example.timeslot.Busy;
import org.example.utilities.CommandLine;
import org.example.utilities.InputHandler;

import java.util.Date;

public class AddMeeting {
    private Calendar calendar;

    public AddMeeting(Calendar calendar) {
        this.calendar = calendar;
    }

    public void promptAndAddMeeting(CommandLine commandLine, InputHandler inputHandler) {
        commandLine.displayMeetingDetailsPrompt();
        int day = inputHandler.nextInt();

        commandLine.displayMonthPrompt();
        int month = inputHandler.nextInt();

        commandLine.displayStartTimePrompt();
        String startTime = inputHandler.next();

        commandLine.displayEndTimePrompt();
        String endTime = inputHandler.next();

        // Assuming the year is the current year for simplicity
        Date meetingDate = new Date();
        meetingDate.setDate(day);
        meetingDate.setMonth(month - 1);

        // Add the meeting to the calendar
        Busy newMeeting = new Busy(startTime, endTime);
        calendar.addTimeSlot(newMeeting);

        System.out.println("Meeting added successfully on " + meetingDate);
    }
}