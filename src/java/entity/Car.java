/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ACER
 */
public class Car {
    private String idCar;
    private String carName;
    private String carType;
    private String manufacturer;
    private String typeFuel;
    private String color;
    private int numberOfSeat;
    private String status;
    private String description;
    private String yearOfManufacture;
    private String img;
    private int pricePerDay;
    private int pricePerHour;
    
    public Car() {
    }

    public Car(String idCar, String carName, String carType, String manufacturer, String typeFuel, String color, int numberOfSeat, String status, String description, String yearOfManufacture, String img, int pricePerDay, int pricePerHour) {
        this.idCar = idCar;
        this.carName = carName;
        this.carType = carType;
        this.manufacturer = manufacturer;
        this.typeFuel = typeFuel;
        this.color = color;
        this.numberOfSeat = numberOfSeat;
        this.status = status;
        this.description = description;
        this.yearOfManufacture = yearOfManufacture;
        this.img = img;
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
    }

    public String getIdCar() {
        return idCar;
    }

    public void setIdCar(String idCar) {
        this.idCar = idCar;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getTypeFuel() {
        return typeFuel;
    }

    public void setTypeFuel(String typeFuel) {
        this.typeFuel = typeFuel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public int getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    @Override
    public String toString() {
        return "Car{" + "idCar=" + idCar + ", carName=" + carName + ", carType=" + carType + ", manufacturer=" + manufacturer + ", typeFuel=" + typeFuel + ", color=" + color + ", numberOfSeat=" + numberOfSeat + ", status=" + status + ", description=" + description + ", yearOfManufacture=" + yearOfManufacture + ", img=" + img + ", pricePerDay=" + pricePerDay + ", pricePerHour=" + pricePerHour + '}';
    }
}
