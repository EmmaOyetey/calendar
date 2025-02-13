package org.example.calendar;

import org.example.timeslot.TimeSlot;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Calendar {
    private List<TimeSlot> timeSlots;
    private String earliestTime;
    private String latestTime;
    private String name;
    private LocalDateTime date;

    public Calendar(String earliestTime, String latestTime, String name, LocalDateTime date) {
        this.timeSlots = new ArrayList<>();
        this.earliestTime = earliestTime;
        this.latestTime = latestTime;
        this.name = name;
        this.date = date;
    }

    public List<TimeSlot> getTimeSlots() {
        return timeSlots;
    }

    public void addTimeSlot(TimeSlot timeSlot) {
        this.timeSlots.add(timeSlot);
    }

    public String getEarliestTime() {
        return earliestTime;
    }

    public void setEarliestTime(String earliestTime) {
        this.earliestTime = earliestTime;
    }

    public String getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(String latestTime) {
        this.latestTime = latestTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "timeSlots=" + timeSlots +
                ", earliestTime='" + earliestTime + '\'' +
                ", latestTime='" + latestTime + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
