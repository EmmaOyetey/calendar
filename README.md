MeetUp Calendar Management System
Welcome to the MeetUp Calendar Management System! This Java-based application helps users manage their calendars, schedule meetings, adjust working hours, and find mutual free time slots with other users.

Table of Contents
Overview
Features
Design Principles
Object-Oriented Programming
Abstract Classes
Enums
Reusability
Interfaces
Setup and Usage
Project Structure
Future Improvements
Overview
The MeetUp Calendar Management System is designed to simplify calendar management for users. Users can add meetings to their calendars, adjust working hours, and find mutual free time slots with other users. The system leverages key Object-Oriented Programming (OOP) principles to ensure a modular, maintainable, and extensible codebase.

Features
Add Meeting: Users can schedule a meeting by specifying the date, start time, and end time.
Adjust Working Hours: Users can adjust their default working hours or specify different working hours for a particular day.
Find Free Time Slots: Users can find mutual free time slots with other users for a specified date.
Design Principles
Object-Oriented Programming
This project employs OOP principles to create a well-structured and modular system. Key OOP principles used include:

Encapsulation: All classes have private fields with public getters and setters.
Inheritance: Classes such as UserCalendar, Sam, Pablo, and Emma extend the abstract Calendar class.
Polymorphism: Methods such as findFreeTimeSlot can operate on objects of the Calendar type, allowing different calendar implementations to be used interchangeably.
Abstraction: Abstract classes and interfaces are used to define common behaviors and properties.
Abstract Classes
The Calendar and TimeSlot classes are abstract, providing a template for specific implementations:

Calendar: Defines common properties and methods for all calendar types.
TimeSlot: Defines common properties and methods for different types of time slots (Available and Busy).
Enums
The TimeSlotStatus enum defines the possible states of a time slot (AVAILABLE and BUSY), ensuring type safety and improving code readability.

Reusability
Abstract Classes and Inheritance: Abstract classes allow common behavior to be defined once and reused across different calendar implementations.
Utility Classes: CalendarUtils provides reusable methods for finding available time slots.
Command Line and Input Handling: Utility classes (CommandLine and InputHandler) encapsulate common functionality, making it easy to reuse and maintain.
Interfaces
While abstract classes are used effectively in this project, interfaces could be introduced to define common behaviors that do not necessarily fit into the class hierarchy. For example, an interface Schedulable could define methods related to scheduling, which could be implemented by different types of calendars or other schedulable entities.

Setup and Usage
Prerequisites
Java Development Kit (JDK) 8 or higher
A Java IDE (e.g., IntelliJ IDEA, Eclipse)
Setup
Clone the repository:

bash
Copy code
git clone https://github.com/your-username/meetup-calendar.git
cd meetup-calendar
Open the project in your IDE.

Build the project:

If using IntelliJ IDEA, open the project and build it using Build > Build Project.
If using Eclipse, right-click on the project and select Run As > Java Application.
Usage
Run the Main class to start the application. Follow the on-screen prompts to add meetings, adjust working hours, and find free time slots with other users.

Project Structure
The project is organized into the following packages:

org.example.calendar:

Calendar (abstract class)
UserCalendar (concrete class)
Sam, Pablo, Emma (concrete classes with predefined data)
org.example.manager:

AddMeeting
AdjustWorkingDayTimes
FreeTimeSlotFinder
org.example.timeslot:

TimeSlot (abstract class)
Available (concrete class)
Busy (concrete class)
TimeSlotStatus (enum)
org.example.utilities:

CalendarUtils
CommandLine
InputHandler
Future Improvements
User Authentication: Add a feature to authenticate users.
Persistent Storage: Save calendar data to a file or database for persistence.
Graphical User Interface (GUI): Develop a GUI for better user interaction.
Conflict Resolution: Add functionality to handle and resolve scheduling conflicts.
Conclusion
The MeetUp Calendar Management System is a comprehensive application demonstrating the power of OOP principles in creating a modular and extensible codebase. By using abstract classes, enums, and utility classes, the project ensures high reusability and maintainability.
