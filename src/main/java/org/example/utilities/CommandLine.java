package org.example.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CommandLine {

    public void displayWelcomePrompt() {
        System.out.println("Welcome to MeetUp. Please enter your name: ");
    }

    public void displayMenuPrompt(String name) {
        System.out.println("Hi " + name + ", What would you like to do?");
    }

    public void displayIdentifyOtherCalendarPrompt(String name) {
        System.out.println(name + ", Who would you like to meet with?");
    }

    public void displayIdentifyDatePrompt(String name) {
        System.out.println("When would you like to meet " + name + "? Please use format dd/mm.");
    }

    public void displayAvailableSlots() {
        System.out.println("The following time slots are available:");
    }

    public void displayMeetingDetails(String formattedStartTime, String formattedEndTime) {
        System.out.println("Meeting: " + formattedStartTime + " - " + formattedEndTime);
    }

    public void displayMainMenu() {
        System.out.println("1. Check Availability");
        System.out.println("2. Add a meeting");
        System.out.println("3. Adjust working day times");
        System.out.println("4. Find available time slot with another person");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

//    public void displayMeetingDetails(String formattedStartTime, String formattedEndTime) {
//        System.out.println("Meeting: " + formattedStartTime + " - " + formattedEndTime);
//    }

    public void displayDayPrompt() {
        System.out.print("Enter the day of the meeting (DD): ");
    }

    public void displayMonthPrompt() {
        System.out.print("Enter the month of the meeting (MM): ");
    }

    public void displayStartTimePrompt() {
        System.out.print("Enter the start time of the meeting (HH:mm): ");
    }

    public void displayEndTimePrompt() {
        System.out.print("Enter the end time of the meeting (HH:mm): ");
    }

    public void meetingAddedSuccessMessage(int day, int month, String formattedStartTime, String formattedEndTime) {
        DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMM");
        String monthName = LocalDate.of(1, month, 1).format(monthFormatter);

        System.out.println("Meeting: " + day + " " + monthName + " Start Time: " + formattedStartTime + " End Time: " + formattedEndTime + " added successfully");
    }


    public void displayAdjustWorkingTimesMenu() {
        System.out.println("1. Adjust start and finish times for all days");
        System.out.println("2. Adjust start and finish times for a specific day");
        System.out.print("Choose an option: ");
    }

    public void displayNewDefaultStartTimePrompt() {
        System.out.print("Enter new default start time (HH:mm): ");
    }

    public void displayNewDefaultEndTimePrompt() {
        System.out.print("Enter new default end time (HH:mm): ");
    }

    public void displaySpecificDayPrompt() {
        System.out.print("Enter the day to adjust: ");
    }

    public void displaySpecificMonthPrompt() {
        System.out.print("Enter the month to adjust: ");
    }

    public void checkSpecificDayPrompt() {
        System.out.print("Enter the day to check: ");
    }

    public void checkSpecificMonthPrompt() {
        System.out.print("Enter the month to check: ");
    }

    public void displayNewStartTimePrompt() {
        System.out.print("Enter new start time for this day (HH:mm): ");
    }

    public void displayNewEndTimePrompt() {
        System.out.print("Enter new end time for this day (HH:mm): ");
    }

    public void displayAdjustedTimesSuccess(){
        System.out.println("Default working hours updated successfully.");
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public LocalDate promptForDate(InputHandler inputHandler) {
        while (true) {
            System.out.print("Enter the date (dd/MM): ");
            String dateInput = inputHandler.next();
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");
                return LocalDate.parse(dateInput, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in the format dd/MM.");
            }
        }
    }

    public void displayAvailabilityMenu(){
            System.out.println("What availability would you like to check?");
            System.out.println("1. A Specific day");
            System.out.println("2. All Meetings");
            System.out.print("Choose an option: ");
        }

        public void displayInvalidInputMessage(){
            System.out.println("Invalid choice. Please try again.");
        }

    public void displayPromptForTime(String type) {
        System.out.print("Enter the " + type + " time of the meeting (HH:mm): ");
    }

    public void displayInvalidTimeFormat() {
        System.out.println("Invalid time format. Please enter the time in HH:mm format.");
    }
}
