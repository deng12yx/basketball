package com.example.basketballteam.model;

public class Schedule {
    private int scheduleId;
    private String scheduleTime;
    private String scheduleRival;
    private int scheduleResult;
    private String scheduleScore;
    public Schedule(){

    }


    public Schedule(int scheduleId, String scheduleTime, String scheduleRival, int scheduleResult, String scheduleScore) {
        this.scheduleId = scheduleId;
        this.scheduleTime = scheduleTime;
        this.scheduleRival = scheduleRival;
        this.scheduleResult = scheduleResult;
        this.scheduleScore = scheduleScore;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public String getScheduleRival() {
        return scheduleRival;
    }

    public void setScheduleRival(String scheduleRival) {
        this.scheduleRival = scheduleRival;
    }

    public int getScheduleResult() {
        return scheduleResult;
    }

    public void setScheduleResult(int scheduleResult) {
        this.scheduleResult = scheduleResult;
    }

    public String getScheduleScore() {
        return scheduleScore;
    }

    public void setScheduleScore(String scheduleScore) {
        this.scheduleScore = scheduleScore;
    }
}
