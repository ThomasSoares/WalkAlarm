package com.example.walkalarm.Classes;

public class Alarm
{
    private String daysTextView,timeTextView,soundTextView,stepsTextView,statusTextView;

    public Alarm()
    {

    }

    public Alarm(String statusTextView, String daysTextView, String timeTextView, String soundTextView, String stepsTextView)
    {
        this.statusTextView=statusTextView;
        this.daysTextView=daysTextView;
        this.timeTextView=timeTextView;
        this.soundTextView=soundTextView;
        this.stepsTextView=stepsTextView;
    }

    public String getStatusTextView() {
        return statusTextView;
    }

    public void setStatusTextView(String statusTextView) {
        this.statusTextView = statusTextView;
    }

    public String getDaysTextView() {
        return daysTextView;
    }

    public void setDaysTextView(String daysTextView) {
        this.daysTextView = daysTextView;
    }
    public String getTimeTextView() {
        return timeTextView;
    }

    public void setTimeTextView(String timeTextView) {
        this.timeTextView = timeTextView;
    }

    public String getSoundTextView() {
        return soundTextView;
    }

    public void setSoundTextView(String soundTextView) {
        this.soundTextView = soundTextView;
    }

    public String getStepsTextView() {
        return stepsTextView;
    }

    public void setStepsTextView(String stepsTextView) {
        this.stepsTextView = stepsTextView;
    }
}
