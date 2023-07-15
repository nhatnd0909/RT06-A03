/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ACER
 */
public class ScheduleDay1 {
    private String fromDay;
    private int numday;

    public ScheduleDay1(String fromDay, int numday) {
        this.fromDay = fromDay;
        this.numday = numday;
    }

    public String getFromDay() {
        return fromDay;
    }

    public void setFromDay(String fromDay) {
        this.fromDay = fromDay;
    }

    public int getNumday() {
        return numday;
    }

    public void setNumday(int numday) {
        this.numday = numday;
    }

    @Override
    public String toString() {
        return "ScheduleDay1{" + "fromDay=" + fromDay + ", numday=" + numday + '}';
    }
    
}
