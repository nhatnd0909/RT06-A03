/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author ACER
 */
public class Account {

    private int ID;
    private String name;
    private String userName;
    private String password;
    private String CCCD;
    private Date DOB;
    private String gender;
    private String phone;
    private String email;
    private String license;
    private String imgLicense;
    private String imgCCCD;
    private boolean role;
    private String address;

    public Account() {
    }

    public Account(int ID, String name, String userName, String password, String CCCD, Date DOB, String gender, String phone, String email, String license, String imgLicense, String imgCCCD, boolean role, String address) {
        this.ID = ID;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.CCCD = CCCD;
        this.DOB = DOB;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.license = license;
        this.imgLicense = imgLicense;
        this.imgCCCD = imgCCCD;
        this.role = role;
        this.address = address;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getImgLicense() {
        return imgLicense;
    }

    public void setImgLicense(String imgLicense) {
        this.imgLicense = imgLicense;
    }

    public String getImgCCCD() {
        return imgCCCD;
    }

    public void setImgCCCD(String imgCCCD) {
        this.imgCCCD = imgCCCD;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Account{" + "ID=" + ID + ", name=" + name + ", userName=" + userName + ", password=" + password + ", CCCD=" + CCCD + ", DOB=" + DOB + ", gender=" + gender + ", phone=" + phone + ", email=" + email + ", license=" + license + ", imgLicense=" + imgLicense + ", imgCCCD=" + imgCCCD + ", role=" + role + ", address=" + address + '}';
    }
    
}
