/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ACER
 */
public class ScheduleHour {
    private String fromHour;
    private String toHour;

    public ScheduleHour() {
    }

    public ScheduleHour(String fromHour, String toHour) {
        this.fromHour = fromHour;
        this.toHour = toHour;
    }

    public String getFromHour() {
        return fromHour;
    }

    public void setFromHour(String fromHour) {
        this.fromHour = fromHour;
    }

    public String getToHour() {
        return toHour;
    }

    public void setToHour(String toHour) {
        this.toHour = toHour;
    }

    @Override
    public String toString() {
        return "ScheduleHour{" + "fromHour=" + fromHour + ", toHour=" + toHour + '}';
    }
    
}
