package org.example.utilities;

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


    public void displayMainMenu() {
        System.out.println("1. Add a meeting");
        System.out.println("2. Adjust working day times");
        System.out.println("3. Find available time slot with another person");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    public void displayMeetingDetailsPrompt() {
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

    public void displayAdjustWorkingTimesMenu() {
        System.out.println("1. Adjust default start and finish times for all days");
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

    public void displayNewStartTimePrompt() {
        System.out.print("Enter new start time for this day (HH:mm): ");
    }

    public void displayNewEndTimePrompt() {
        System.out.print("Enter new end time for this day (HH:mm): ");
    }
}
