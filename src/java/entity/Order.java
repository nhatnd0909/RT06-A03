/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ACER
 */
public class Order {
    private String idOrder;
    private String idUser;
    private String idStaff;
    private String idCar;
    private String typeRent;
    private String typeReceive;

    public Order() {
    }

    public Order(String idOrder, String idUser, String idStaff, String idCar, String typeRent, String typeReceive) {
        this.idOrder = idOrder;
        this.idUser = idUser;
        this.idStaff = idStaff;
        this.idCar = idCar;
        this.typeRent = typeRent;
        this.typeReceive = typeReceive;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
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

    public String getTypeReceive() {
        return typeReceive;
    }

    public void setTypeReceive(String typeReceive) {
        this.typeReceive = typeReceive;
    }

    @Override
    public String toString() {
        return "Order{" + "idOrder=" + idOrder + ", idUser=" + idUser + ", idStaff=" + idStaff + ", idCar=" + idCar + ", typeRent=" + typeRent + ", typeReceive=" + typeReceive + '}';
    }
    
}
