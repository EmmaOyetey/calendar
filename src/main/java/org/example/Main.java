package org.example;

import org.example.calendar.*;
import org.example.calendar.AdjustWorkingDayTimes;
import org.example.manager.FreeTimeSlotFinder;
import org.example.manager.*;
import org.example.utilities.CommandLine;
import org.example.utilities.InputHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CommandLine commandLine = new CommandLine();
        InputHandler inputHandler = new InputHandler();

        commandLine.displayWelcomePrompt();
        String name = inputHandler.nextLine();
        commandLine.displayMenuPrompt(name);

        Calendar userCalendar = new UserCalendar("08:00", "18:00", name, new Date());

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
                    AddMeeting addMeeting = new AddMeeting(userCalendar);
                    addMeeting.promptAndAddMeeting(commandLine, inputHandler);
                    break;
                case 2:
                    AdjustWorkingDayTimes adjustTimes = new AdjustWorkingDayTimes(userCalendar);
                    adjustTimes.adjustTimes(commandLine, inputHandler);
                    break;
                case 3:
                    FreeTimeSlotFinder freeTimeSlotFinder = new FreeTimeSlotFinder(userCalendar, allCalendars);
                    freeTimeSlotFinder.findFreeTimeSlot(commandLine, inputHandler);
                    break;
                case 4:
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