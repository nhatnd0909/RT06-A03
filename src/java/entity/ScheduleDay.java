/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ACER
 */
public class ScheduleDay {
    private String fromDay;
    private String toDay;

    public ScheduleDay() {
    }

    public ScheduleDay(String fromDay, String toDay) {
        this.fromDay = fromDay;
        this.toDay = toDay;
    }

    public String getFromDay() {
        return fromDay;
    }

    public void setFromDay(String fromDay) {
        this.fromDay = fromDay;
    }

    public String getToDay() {
        return toDay;
    }

    public void setToDay(String toDay) {
        this.toDay = toDay;
    }

    @Override
    public String toString() {
        return "ScheduleDay{" + "fromDay=" + fromDay + ", toDay=" + toDay + '}';
    }
    
}
