package org.example.manager;

import org.example.utilities.CommandLine;
import org.example.utilities.InputHandler;
import org.example.calendar.Calendar;

import java.time.LocalTime;

public class AdjustWorkingDayTimes {
    private Calendar calendar;

    public AdjustWorkingDayTimes(Calendar calendar) {
        this.calendar = calendar;
    }

    public void adjustTimes(CommandLine commandLine, InputHandler inputHandler) {
        commandLine.displayAdjustWorkingTimesMenu();
        int choice = inputHandler.nextInt();

        switch (choice) {
            case 1:
                adjustDefaultTimes(commandLine, inputHandler);
                break;
            case 2:
                adjustSpecificDayTimes(commandLine, inputHandler);
                break;
            default:
                commandLine.displayInvalidInputMessage();
                break;
        }
    }
    private void adjustDefaultTimes(CommandLine commandLine, InputHandler inputHandler) {
        commandLine.displayNewDefaultStartTimePrompt();
        LocalTime startTime = inputHandler.nextLocalTime();

        commandLine.displayNewDefaultEndTimePrompt();
        LocalTime endTime = inputHandler.nextLocalTime();

        calendar.setEarliestTime(String.valueOf(startTime));
        calendar.setLatestTime(String.valueOf(endTime));

        commandLine.displayAdjustedTimesSuccess();
    }

    private void adjustSpecificDayTimes(CommandLine commandLine, InputHandler inputHandler) {
        commandLine.displaySpecificDayPrompt();
        int day = inputHandler.nextInt();

        commandLine.displaySpecificMonthPrompt();
        int month = inputHandler.nextInt();

        commandLine.displayNewStartTimePrompt();
        LocalTime startTime = inputHandler.nextLocalTime();

        commandLine.displayNewEndTimePrompt();
        LocalTime endTime = inputHandler.nextLocalTime();

        commandLine.displayMessage("Specific working hours updated successfully for " + day + "/" + month + ".");
    }
}
