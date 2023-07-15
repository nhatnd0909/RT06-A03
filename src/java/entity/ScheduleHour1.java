/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ACER
 */
public class ScheduleHour1 {

    private String fromHour;
    private int numHour;

    public ScheduleHour1(String fromHour, int numHour) {
        this.fromHour = fromHour;
        this.numHour = numHour;
    }

    public String getFromHour() {
        return fromHour;
    }

    public void setFromHour(String fromHour) {
        this.fromHour = fromHour;
    }

    public int getNumHour() {
        return numHour;
    }

    public void setNumHour(int numHour) {
        this.numHour = numHour;
    }

    @Override
    public String toString() {
        return "ScheduleHour1{" + "fromHour=" + fromHour + ", numHour=" + numHour + '}';
    }
    
}
