package org.example;

import org.example.calendar.*;
import org.example.manager.*;
import org.example.utilities.CommandLine;
import org.example.utilities.InputHandler;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CommandLine commandLine = new CommandLine();
        InputHandler inputHandler = new InputHandler();

        commandLine.displayWelcomePrompt();
        String name = inputHandler.nextLine();
        commandLine.displayMenuPrompt(name);

        LocalDateTime now = LocalDateTime.now();

        Calendar userCalendar;
        switch (name) {
            case "Emma":
                userCalendar = new Emma();
                break;
            case "Pablo":
                userCalendar = new Pablo();
                break;
            case "Sam":
                userCalendar = new Sam();
                break;
            default:
                userCalendar = new UserCalendar("08:00", "18:00", name, now);
                break;
        }

        List<Calendar> allCalendars = new ArrayList<>();
        allCalendars.add(userCalendar);
        allCalendars.add(new Sam());
        allCalendars.add(new Pablo());
        allCalendars.add(new Emma());

        boolean running = true;

        while (running) {
            commandLine.displayMainMenu();
            int choice = inputHandler.nextInt();

            switch (choice) {
                case 1:
                    CheckDayAvailability checkAvailability = new CheckDayAvailability(userCalendar);
                    checkAvailability.checkAvailability(commandLine, inputHandler);
                    break;
                case 2:
                    AddMeeting addMeeting = new AddMeeting(userCalendar);
                    addMeeting.promptAndAddMeeting(commandLine, inputHandler);
                    break;
                case 3:
                    AdjustWorkingDayTimes adjustTimes = new AdjustWorkingDayTimes(userCalendar);
                    adjustTimes.adjustTimes(commandLine, inputHandler);
                    break;
                case 4:
                    FreeTimeSlotFinder freeTimeSlotFinder = new FreeTimeSlotFinder(userCalendar, allCalendars);
                    freeTimeSlotFinder.findFreeTimeSlot(commandLine, inputHandler);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        inputHandler.close();
    }
}