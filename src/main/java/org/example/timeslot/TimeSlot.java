package org.example.timeslot;

public abstract class TimeSlot {
    protected String startTime;
    protected String endTime;
    protected TimeSlotStatus status;

//    public TimeSlot(String startTime, String endTime, TimeSlotStatus status) {
//        this.startTime = startTime;
//        this.endTime = endTime;
//        this.status = status;
//    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public org.example.timeslot.TimeSlotStatus getStatus() {
        return status;
    }

    public void setStatus(org.example.timeslot.TimeSlotStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TimeSlot{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", status=" + status +
                '}';
    }
}
