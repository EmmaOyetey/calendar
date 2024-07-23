# MeetUp Calendar

## Overview
**Welcome to the MeetUp Calendar! This Java-based application helps users manage their calendars, schedule meetings, adjust working hours, and find mutual free time slots with other users. The MeetUp Calendar is designed to simplify calendar management for users. Users can add meetings to their calendars, adjust working hours, and find mutual free time slots with other users. The system leverages key Object-Oriented Programming (OOP) principles to ensure a modular, maintainable, and extensible codebase.

## Features
Add Meeting: Users can schedule a meeting by specifying the date, start time, and end time.
Adjust Working Hours: Users can adjust their default working hours or specify different working hours for a particular day. *To come
Find Free Time Slots: Users can find mutual free time slots with other users for a specified date.

## Object-Oriented Programming
This project employs OOP principles to create a well-structured and modular system. Key OOP principles used include:
  **Encapsulation:** All classes have private fields with public getters and setters.          
  **Inheritance:** Classes such as UserCalendar, Sam, Pablo, and Emma extend the abstract Calendar class.                    
  **Polymorphism:** Methods such as findFreeTimeSlot can operate on objects of the Calendar type, allowing different calendar implementations to be used interchangeably.                    
  **Abstraction:** Abstract classes and interfaces are used to define common behaviors and properties. The Calendar and TimeSlot classes are abstract, providing a template for specific implementations; Calendar: Defines common properties and methods for all calendar types. TimeSlot: Defines common properties and methods for different types of time slots (Available and Busy).
  **Enums:** The TimeSlotStatus enum defines the possible states of a time slot (AVAILABLE and BUSY), ensuring type safety and improving code readability.
  

## Reusability
  **Abstract Classes and Inheritance:** Abstract classes allow common behavior to be defined once and reused across different calendar implementations.                
  **Utility Classes:** CalendarUtils provides reusable methods for finding available time slots.                 
  **Command Line and Input Handling:** Utility classes (CommandLine and InputHandler) encapsulate common functionality, making it easy to reuse and maintain.                     

## Usage
Run the Main class to start the application. Follow the on-screen prompts to add meetings, adjust working hours, and find free time slots with other users.

## Project Structure
The project is organized into the following packages:

**org.example.calendar:**                 
    Calendar (abstract class),
    UserCalendar (concrete class),
    Sam, Pablo, Emma (concrete classes with predefined data)
**org.example.manager:**             
    AddMeeting,
    AdjustWorkingDayTimes,
    FreeTimeSlotFinder,   
    CheckDayAvailability                               
**org.example.timeslot;**            
    TimeSlotStatus (enum),
    TimeSlot (abstract class),
    Available (concrete class),
    Busy (concrete class)    
**org.example.utilities:**            
    CalendarUtils,
    CommandLine,
    InputHandler

## Future Improvements

**Interfaces** While abstract classes are used effectively in this project, interfaces could be introduced to define common behaviors that do not necessarily fit into the class hierarchy. For example, an interface Schedulable   could define methods related to scheduling, which could be implemented by different types of calendars or other schedulable entities.                           
**User Authentication:** Add a feature to authenticate users.                      
**Persistent Storage:** Save calendar data to a file or database for persistence.              
**Graphical User Interface (GUI):** Develop a GUI for better user interaction.                   
**Conflict Resolution:** Add functionality to handle and resolve scheduling conflicts.                             
   
