/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ACER
 */
public class OrderDetail {

    private String idOrder;
    private int idUser;
    private String idStaff;
    private String idCar;
    private String typeRent;
    private String typeRecieve;
    private String fromDay;
    private String numDay;
    private String fromHour;
    private String numHour;
    private String location;
    private int totalPrice;
    private String methodPay;
    private String status;
    private String isReturn;
    private String returnDay;

    public OrderDetail() {
    }

    public OrderDetail(String idOrder, int idUser, String idStaff, String idCar, String typeRent, String typeRecieve, String fromDay, String numDay, String fromHour, String numHour, String location, int totalPrice, String methodPay, String status, String isReturn, String returnDay) {
        this.idOrder = idOrder;
        this.idUser = idUser;
        this.idStaff = idStaff;
        this.idCar = idCar;
        this.typeRent = typeRent;
        this.typeRecieve = typeRecieve;
        this.fromDay = fromDay;
        this.numDay = numDay;
        this.fromHour = fromHour;
        this.numHour = numHour;
        this.location = location;
        this.totalPrice = totalPrice;
        this.methodPay = methodPay;
        this.status = status;
        this.isReturn = isReturn;
        this.returnDay = returnDay;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(String idStaff) {
        this.idStaff = idStaff;
    }

    public String getIdCar() {
        return idCar;
    }

    public void setIdCar(String idCar) {
        this.idCar = idCar;
    }

    public String getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(String typeRent) {
        this.typeRent = typeRent;
    }

    public String getTypeRecieve() {
        return typeRecieve;
    }

    public void setTypeRecieve(String typeRecieve) {
        this.typeRecieve = typeRecieve;
    }

    public String getFromDay() {
        return fromDay;
    }

    public void setFromDay(String fromDay) {
        this.fromDay = fromDay;
    }

    public String getNumDay() {
        return numDay;
    }

    public void setNumDay(String numDay) {
        this.numDay = numDay;
    }

    public String getFromHour() {
        return fromHour;
    }

    public void setFromHour(String fromHour) {
        this.fromHour = fromHour;
    }

    public String getNumHour() {
        return numHour;
    }

    public void setNumHour(String numHour) {
        this.numHour = numHour;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getMethodPay() {
        return methodPay;
    }

    public void setMethodPay(String methodPay) {
        this.methodPay = methodPay;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(String isReturn) {
        this.isReturn = isReturn;
    }

    public String getReturnDay() {
        return returnDay;
    }

    public void setReturnDay(String returnDay) {
        this.returnDay = returnDay;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "idOrder=" + idOrder + ", idUser=" + idUser + ", idStaff=" + idStaff + ", idCar=" + idCar + ", typeRent=" + typeRent + ", typeRecieve=" + typeRecieve + ", fromDay=" + fromDay + ", numDay=" + numDay + ", fromHour=" + fromHour + ", numHour=" + numHour + ", location=" + location + ", totalPrice=" + totalPrice + ", methodPay=" + methodPay + ", status=" + status + ", isReturn=" + isReturn + ", returnDay=" + returnDay + '}';
    }
    

}
