package org.example.calendar;

import org.example.utilities.CommandLine;
import org.example.utilities.InputHandler;

public class AdjustWorkingDayTimes {
    private Calendar calendar;

    public AdjustWorkingDayTimes(Calendar calendar) {
        this.calendar = calendar;
    }

    public void adjustTimes(CommandLine commandLine, InputHandler inputHandler) {
        commandLine.displayAdjustWorkingTimesMenu();
        int choice = inputHandler.nextInt();

        if (choice == 1) {
            commandLine.displayNewDefaultStartTimePrompt();
            String startTime = inputHandler.next();

            commandLine.displayNewDefaultEndTimePrompt();
            String endTime = inputHandler.next();

            calendar.setEarliestTime(startTime);
            calendar.setLatestTime(endTime);

            System.out.println("Default working hours updated successfully.");
        } else if (choice == 2) {
            commandLine.displaySpecificDayPrompt();
            int day = inputHandler.nextInt();

            commandLine.displaySpecificMonthPrompt();
            int month = inputHandler.nextInt();

            commandLine.displayNewStartTimePrompt();
            String startTime = inputHandler.next();

            commandLine.displayNewEndTimePrompt();
            String endTime = inputHandler.next();

            System.out.println("Specific working hours updated successfully for " + day + "/" + month + ".");
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
